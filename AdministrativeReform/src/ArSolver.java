import java.util.Queue;
import java.util.TreeMap;

public class ArSolver {

	private int c;
	private int r;
	private TreeMap<Integer, TreeMap<Integer, Integer>> adj;
	private int c1;
	private int c2;
	private Vector<Integer> v = new Vector<Integer>(c,Integer.MAX_VALUE-200);//not max_int to avoid overflow
	
	
	public ArSolver(int communities, int roads, TreeMap<Integer,TreeMap<Integer,Integer>> adj, String[] capitals) {
		this.c=communities;
		this.r=roads;
		this.adj=adj;
		this.c1 = Integer.parseInt(capitals[0]);
		this.c2 = Integer.parseInt(capitals[1]);
	}

	public void solve() {
		
		
	}
	
	
	public void dijkstra(TreeMap<Integer,TreeMap<Integer,Integer>> adj,int x){
		boolean[] s = new boolean[c];
		int[] length = new int[c];
		
		
	}
	
	
	
	public String getAnswer() {
		// TODO Auto-generated method stub
		return null;
	}

}
