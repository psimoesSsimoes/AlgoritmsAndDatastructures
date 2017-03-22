package packageA;
import java.util.Deque;
import java.util.LinkedList;


public class RobotTruckSolver {
	private Point[] pts;
	private int[] sumw;
	private int[] sumd;
	private Deque<Integer> queue = new LinkedList<Integer>();
	private int npackages;
	private int weight;
	private int[] dp;

	public RobotTruckSolver(Point[] pts, int[] sumw, int[] sumd, int npackages,
			int weight) {
		this.pts = pts;
		this.sumw = sumw;
		this.sumd = sumd;
		this.npackages = npackages;
		this.weight = weight;
		this.dp = new int[100000+10];
	}

	public Point[] getPts() {
		return pts;
	}

	public int[] getSumw() {
		return sumw;
	}

	public int[] getSumd() {
		return sumd;
	}

	public int solve() {
		queue.addFirst(0);
		for (int i = 1; i <= npackages; i++) {

			while (!queue.isEmpty()
					&& sumw[i] - sumw[queue.peekFirst()] > weight) {
				queue.removeFirst();
			}
			dp[i] = func(queue.peekFirst()) + sumd[i] + pts[i].getD();
			while (!queue.isEmpty() && func(i) <= func(queue.peekLast())) {
				queue.removeLast();
			}
			queue.addLast(i);
		}

		return dp[npackages];
	}

	private int func(int j) {
		return dp[j] - sumd[j + 1] + pts[j + 1].getD();
	}
}
