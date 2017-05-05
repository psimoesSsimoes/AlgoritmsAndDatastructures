import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br = null;
		FileReader fr = null;
		char[][] grid = new char[42][50];
		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("/home/psimoes/test4.txt"));
			
			String[] c_r = br.readLine().split(" ");
			int communities = Integer.parseInt(c_r[0]);
			int roads = Integer.parseInt(c_r[1]);
			Queue<String[]> all_roads = new LinkedList<String[]>();
			for (int i = 0; i < roads; i++){
				String[] road_x = br.readLine().split(" ");
				all_roads.add(road_x);
			}
			String[] capitals = br.readLine().split(" ");
			ArSolver slv = new ArSolver(communities,roads,all_roads,capitals);
			
			
			
			
			
			

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
