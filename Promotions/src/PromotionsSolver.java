
import java.util.Map;
import java.util.Queue;

public class PromotionsSolver {

	private int[] vis1 = new int[5001], vis2 = new int[5001], cnt1 = new int[5001], cnt2 = new int[5001];
	private Map<Integer, Queue<Integer>> a1;
	private Map<Integer, Queue<Integer>> a2;
	private int n;
	private int a;
	private int b;
	private String answer = "";

	private void dfs1(int x) {
		if (vis1[x] == 1)
			return;
		vis1[x] = 1;
		cnt1[x]++;
		try {
			for (int i = 0; i < a1.get(x).size(); i++) {

				dfs1(a1.get(x).poll());

			}
		} catch (Exception e) {
			return;
		}
	}

	private void dfs2(int x) {
		if (vis2[x] == 1)
			return;
		vis2[x] = 1;
		cnt2[x]++;
		try {
			for (int i = 0; i < a2.get(x).size(); i++) {

				dfs2(a2.get(x).poll());
			}
		} catch (Exception e) {
			return;
		}
	}

	

	public PromotionsSolver(Map<Integer, Queue<Integer>> a1, Map<Integer, Queue<Integer>> a2, int n, int a, int b) {
		this.a1 = a1;
		this.a2 = a2;
		this.n = n;
		this.a = a;
		this.b = b;
	}

	public void solve() {
		for (int i = 0; i < n; i++) {
			dfs1(i);
			dfs2(i);
		}
		int ans1 = 0, ans2 = 0, ans3 = 0;

		for (int i = 0; i < n; i++) {
			if (cnt1[i] > b)
				ans3++;
			if (cnt2[i] > n - a)
				ans1++;
			if (cnt2[i] > n - b)
				ans2++;
		}
		answer = ans1 + " " + ans2 + " " + ans3;

	}

	public String answer() {
		return answer;
	}

}
