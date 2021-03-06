import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Vector;

public class Main {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = null;
		FileReader fr = null;
		Vector< Vector< AbstractMap.SimpleEntry<Integer,Integer> > > AdjList = new Vector< Vector< AbstractMap.SimpleEntry<Integer,Integer> > >();
		try {

	

			br = new BufferedReader(new InputStreamReader(System.in));

			String[] c_r = br.readLine().split(" ");
			int communities = Integer.parseInt(c_r[0]);
			int roads = Integer.parseInt(c_r[1]);
			for (int j = 0; j < communities*2;j++){
				Vector<SimpleEntry<Integer,Integer>> n = 
						new Vector < SimpleEntry<Integer,Integer> >();
				AdjList.add(n);
			}
			for (int i = 0; i < roads; i++) {
				String[] r = br.readLine().split(" ");
				int o = Integer.parseInt(r[0]);
				int a = Integer.parseInt(r[1]);
				int w = Integer.parseInt(r[2]);
				AdjList.get(o).add(new SimpleEntry<Integer,Integer>(a, w));
				AdjList.get(a).add(new SimpleEntry<Integer,Integer>(o, w));
			}
			String[] capitals = br.readLine().split(" ");
			ArSolver slv = new ArSolver(communities, roads, AdjList, capitals);
			slv.solve();
			System.out.println(slv.solution());
			
			
			

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
