import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	private static final String FILENAME = "/root/gitlab/AlgoritmsAndDatastructures/HardWeeks/hardtest.txt";
	public static void main(String[] args) throws IOException {
		
		
		
		
		
		
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);


			br = new BufferedReader(new FileReader(FILENAME));
			String[] input = br.readLine().split(" ");
			
			int t = Integer.parseInt(input[0]);
			int p = Integer.parseInt(input[1]);
			int l = Integer.parseInt(input[2]);
			
			int[][] adj_matrix = new int[t][t];
			int[] control = new int[t];
			 
			//as it receives input builds the adjacentes matrix and checks on control the colums occupied 
			for(int i = 0 ; i< p ;i++){
				String[] precedences = br.readLine().split(" "); 
				int ptask = Integer.parseInt(precedences[0]);
				int atask = Integer.parseInt(precedences[1]);
				print(ptask + " " +atask);
				adj_matrix[ptask][atask]=1;
				control[atask]++;
			}
			printGrid(adj_matrix);
			HardWeeksSolver slv = new HardWeeksSolver(adj_matrix,control,l);
			slv.solve();
			print(slv.answer());
			print("Finished!");
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
		
		
		
		/**
		
		
		
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] input = buf.readLine().split(" ");
		*/
		
		
		
		
		//buf.close();

	}
	/**
	 * given a grid of w or d or m prints that grid
	 * @param a
	 */
	public static void printGrid(int[][] a) {
		/**
		 * int rows = matrix.length; int cols = matrix[0].length;
		 */
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	private static void print(String a){
		System.out.println(a);
	}
	private static void print(int a){
		System.out.println(a);
	}

}
