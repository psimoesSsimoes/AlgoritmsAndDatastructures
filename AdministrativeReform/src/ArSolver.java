
import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

public class ArSolver {

	private int INF = Integer.MAX_VALUE;
	private int c;
	private int r;
	private Vector<Vector<SimpleEntry<Integer, Integer>>> adj;
	private int c1;
	private int c2;
	int[] sol=new int[3];
	public ArSolver(int communities, int roads, Vector<Vector<SimpleEntry<Integer, Integer>>> adjList,
			String[] capitals) {
		this.c = communities;
		this.r = roads;
		this.adj = adjList;
		this.c1 = Integer.parseInt(capitals[0]);
		this.c2 = Integer.parseInt(capitals[1]);
	}

	public void solve() {
		Vector<Integer> dist_c1 = dijkstra(c1);
		Vector<Integer> dist_c2 = dijkstra(c2);
		for(int i = 0; i< c; i++){
			if(dist_c1.get(i) < dist_c2.get(i)){
				sol[0]++;
			}
			if(dist_c1.get(i)==dist_c2.get(i) && dist_c2.get(i)!=INF){
				sol[2]++;
			}
			if(dist_c1.get(i) > dist_c2.get(i))
				sol[1]++;
			
			
		}
	}
	
	public String solution(){
		return sol[0]+" "+sol[1]+ " "+sol[2];
	}
	
	public Vector<Integer> dijkstra(int s) {
		Vector<Integer> dist = new Vector<Integer>();
		dist.addAll(Collections.nCopies(r+1, INF));
		dist.set(s, 0); // INF = 1*10^9 not MAX_INT to avoid overflow
		PriorityQueue<SimpleEntry<Integer, Integer>> pq = new PriorityQueue<SimpleEntry<Integer, Integer>>(1,
				new Comparator<SimpleEntry<Integer, Integer>>() { 
					public int compare(SimpleEntry<Integer, Integer> i, SimpleEntry<Integer, Integer> j) {
						return i.getKey() - j.getKey();
					}
				});
		pq.offer(new SimpleEntry<Integer,Integer>(0,s));//sorts based on increasing distance
		
		while(!pq.isEmpty()){
			SimpleEntry<Integer,Integer> top = pq.poll();
			int d = top.getKey(),u=top.getValue();
			if(d > dist.get(u)) continue;
			Iterator<SimpleEntry<Integer, Integer>> it = adj.get(u).iterator();
			while(it.hasNext()){
				SimpleEntry<Integer,Integer> p = (SimpleEntry<Integer,Integer>) it.next();
				int v= p.getKey();
				int w_o_a = p.getValue();
				if(dist.get(u)+w_o_a < dist.get(v)){
					dist.set(v, dist.get(u) + w_o_a);
					pq.offer(new SimpleEntry<Integer,Integer>(dist.get(v), v));
				}
			}
		}
		return dist;
	}
	
	public String getAnswer() {
		// TODO Auto-generated method stub
		return null;
	}

}
