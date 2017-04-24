import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class HardWeeksSolver {

	private int[][] matrix;
	private int[] control;
	private int limit;
	private int maxWeek;
	private int nHardWeeks = 0;

	public HardWeeksSolver(int[][] adj_matrix, int[] control, int l) {
		this.matrix = adj_matrix;
		this.control = control;
		this.limit = l;
	}

	/**
	 * first case looks for false in colums. from there calculates hard weeks.
	 */
	public void solve() {
		Queue<Integer> startingPoint = findBeginning();

		if (startingPoint.size() > limit) {
			maxWeek = startingPoint.size();
			nHardWeeks += 1;
		}

		while (!startingPoint.isEmpty()) {
			Queue<Integer> week = new LinkedList<Integer>();
			while (!startingPoint.isEmpty()) {
				int row = startingPoint.poll();
				for (int j = 0; j < control.length; j++) {
					if (matrix[row][j] == 1) {
						if (control[j] <= 1) {
							if (!(control[j] == 0))
								control[j]--;
							week.add(j);
							
						}else{
							control[j]--;
						}
					}
				}
			}
			if (week.size() > limit)
				nHardWeeks++;
			if (maxWeek < week.size()) {
				maxWeek = week.size();
			}

			startingPoint.addAll(week);

		}

	}
	// beginning is control[i]==0
	private Queue<Integer> findBeginning() {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < control.length; i++) {
			if (control[i] == 0)
				q.add(i);
		}
		return q;
	}

	public String answer() {
		// TODO Auto-generated method stub
		return maxWeek + " " + nHardWeeks;
	}

}
