import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	private static final String FILENAME = "/home/psimoes/gitlab/ADA/HardWeeks/hardtest.txt";
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
			
			boolean[] control = new boolean[t]; 
			//as it receives input builds the adjacentes matrix and checks on control the colums occupied 
			for(int i = 0 ; i< p ;i++){
				String[] precedences = br.readLine().split(" "); 
				int ptask = Integer.parseInt(precedences[0]);
				int atask = Integer.parseInt(precedences[1]);
				adj_matrix[ptask][atask]=1;
				control[atask]=true;
			}
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
		
		
		
		
		
		
		
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] input = buf.readLine().split(" ");
		
		
		
		
		
		buf.close();

	}
	
	private static void print(String a){
		System.out.println(a);
	}
	private static void print(int a){
		System.out.println(a);
	}

}
