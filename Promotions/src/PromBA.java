import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;



public class PromBA // Boolean Arrays
{

	private int nNodes;

	private int[] inDegree;

	private List<Integer>[] outEdges;

	private boolean[][] preds;

	private int[] nSucs;

	private int[] nPreds;

	@SuppressWarnings("unchecked")
	public PromBA(int numNodes) {
		nNodes = numNodes;
		inDegree = new int[nNodes];
		outEdges = (List<Integer>[]) new List[nNodes];
		for (int i = 0; i < nNodes; i++)
			outEdges[i] = new LinkedList<Integer>();
		preds = new boolean[nNodes][nNodes];
		nSucs = new int[nNodes];
		nPreds = new int[nNodes];
	}

	public void addEdge(int tail, int head) {
		inDegree[head]++;
		outEdges[tail].add(head);
	}

	private void compNumsPredSuc() {
		this.compPreds();
		for (int i = 0; i < nNodes; i++)
			for (int j = 0; j < nNodes; j++)
				if (preds[i][j]) {
					nPreds[i]++;
					nSucs[j]++;
				}
	}

	private void compPreds() {
		Deque<Integer> ready = new ArrayDeque<Integer>(nNodes);

		for (int i = 0; i < nNodes; i++) {
			preds[i][i] = true;
			if (inDegree[i] == 0)
				ready.addLast(i);
		}

		do {
			int v = ready.removeFirst();
			for (int w : outEdges[v]) {
				this.addAll(preds[v], preds[w]);
				inDegree[w]--;
				if (inDegree[w] == 0)
					ready.add(w);
			}
		} while (!ready.isEmpty());
	}

	private void addAll(boolean[] inVec, boolean[] outVec) {
		for (int i = 0; i < inVec.length; i++)
			if (inVec[i])
				outVec[i] = true;
	}

	// Node v is guaranteed to be promoted at value iff
	// nodes - ( nSucs[v] - 1 ) <= value, that is,
	// nodes - nSucs[v] < value.
	//
	// Node v has no possibility of being promoted at value iff
	// value < nPreds[v].
	//
	public int[] compAnswer(int minValue, int maxValue) {
		this.compNumsPredSuc();

		int promsAtMin = 0;
		int promsAtMax = 0;
		int notPromoted = 0;

		for (int i = 0; i < nNodes; i++) {
			int pos = nNodes - nSucs[i];
			if (pos < minValue)
				promsAtMin++;
			else if (pos < maxValue)
				promsAtMax++;
			else if (maxValue < nPreds[i])
				notPromoted++;
		}
		promsAtMax += promsAtMin;

		return new int[] { promsAtMin, promsAtMax, notPromoted };
	}

	/**
	 * public static void main( String[] args ) throws IOException {
	 * BufferedReader input = new BufferedReader( new
	 * InputStreamReader(System.in) );
	 * 
	 * String[] tokens = input.readLine().split(" "); int minProms =
	 * Integer.parseInt( tokens[0] ); int maxProms = Integer.parseInt( tokens[1]
	 * ); int numNodes = Integer.parseInt( tokens[2] ); int numEdges =
	 * Integer.parseInt( tokens[3] );
	 * 
	 * PromBA dag = new PromBA(numNodes); for ( int i = 0; i < numEdges; i++ ) {
	 * tokens = input.readLine().split(" "); int v = Integer.parseInt( tokens[0]
	 * ); int w = Integer.parseInt( tokens[1] ); dag.addEdge(v, w); }
	 * input.close();
	 * 
	 * int[] answer = dag.compAnswer(minProms, maxProms);
	 * System.out.println(answer[0]); System.out.println(answer[1]);
	 * System.out.println(answer[2]); }
	 */
	public static void main(String[] args) throws IOException {
		/**
		 * BufferedReader input = new BufferedReader( new
		 * InputStreamReader(System.in) );
		 */
		try (BufferedReader input = new BufferedReader(
				new FileReader("/home/psimoes/gitlab/ADA/promotionsInput.txt"))) {

			String[] tokens = input.readLine().split(" ");
			int minProms = Integer.parseInt(tokens[0]);
			int maxProms = Integer.parseInt(tokens[1]);
			int numNodes = Integer.parseInt(tokens[2]);
			int numEdges = Integer.parseInt(tokens[3]);

			PromBA dag = new PromBA(numNodes);
			for (int i = 0; i < numEdges; i++) {
				tokens = input.readLine().split(" ");
				int v = Integer.parseInt(tokens[0]);
				int w = Integer.parseInt(tokens[1]);
				dag.addEdge(v, w);
			}
			input.close();

			int[] answer = dag.compAnswer(minProms, maxProms);
			System.out.println(answer[0]);
			System.out.println(answer[1]);
			System.out.println(answer[2]);

		} catch (Exception e) {

		}
	}

}
