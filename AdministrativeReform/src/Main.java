import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class Main {

	private static TreeMap<Integer, TreeMap<Integer, Integer>> adj;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = null;
		FileReader fr = null;
		adj = new TreeMap<Integer, TreeMap<Integer, Integer>>();

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("/home/psimoes/test4.txt"));

			String[] c_r = br.readLine().split(" ");
			int communities = Integer.parseInt(c_r[0]);
			int roads = Integer.parseInt(c_r[1]);
			Queue<String[]> all_roads = new LinkedList<String[]>();
			for (int i = 0; i < roads; i++) {
				String[] r = br.readLine().split(" ");
				if (!adj.containsKey(Integer.parseInt(r[0]))) {
					TreeMap<Integer, Integer> t = new TreeMap<Integer, Integer>();
					t.put(Integer.parseInt(r[1]), Integer.parseInt(r[2]));
					adj.put(Integer.parseInt(r[0]), t);
				}
				else{
					adj.get(Integer.parseInt(r[0])).put(Integer.parseInt(r[1]), Integer.parseInt(r[2]));
				}
			}
			String[] capitals = br.readLine().split(" ");
			ArSolver slv = new ArSolver(communities, roads, adj, capitals);
			slv.solve();
			System.out.println(slv.getAnswer());
			
			
			

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

}
