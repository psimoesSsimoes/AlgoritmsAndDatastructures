import java.util.AbstractMap;
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

	private int INF = 1000000000;
	private int c;
	private int r;
	private Vector<Vector<SimpleEntry<Integer, Integer>>> adj;
	private int c1;
	private int c2;

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
		System.out.println("atum");
	}

	public Vector<Integer> dijkstra(int s) {
		Vector<Integer> dist = new Vector<Integer>();
		dist.addAll(Collections.nCopies(-1, INF));
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
