import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class HardWeeksSolver {

	private int[][] matrix;
	private boolean[] control;
	private int limit;
	private int maxWeek;
	private int nHardWeeks=0;

	public HardWeeksSolver(int[][] adj_matrix, boolean[] control, int l) {
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
					if(matrix[row][j]==1)
					if (isLonelyCollum(row, j)) {
						matrix[row][j]=0;
						week.add(j);
					}
				}
			}
			if (week.size() > limit )
				nHardWeeks++;
			if (maxWeek < week.size()) {
				maxWeek = week.size();
			}
			startingPoint.addAll(week);
			week.forEach(z->System.out.print(z));
		}
		
	}

	private Queue<Integer> findBeginning() {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < control.length; i++) {
			if (control[i] == false)
				q.add(i);
		}
		return q;
	}

	private boolean isLonelyCollum(int row, int colum) {
		int i = 0;
		for (int f = 0; f < control.length; f++) {
			i += matrix[f][colum];
		}
		if (i == 1)
			return true;
		else
			return false;
	}

	public String answer() {
		// TODO Auto-generated method stub
		return maxWeek + " "+ nHardWeeks;
	}

}
