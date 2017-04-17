import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] input = buf.readLine().split(" ");
		
		int t = Integer.parseInt(input[0]);
		int p = Integer.parseInt(input[1]);
		int l = Integer.parseInt(input[2]);
		
		int[][] adj_matrix = new int[t][t];
		
		
		for(int i = 0 ; i< t ;i++){
			String[] precedences = buf.readLine().split(" "); 
			int ptask = Integer.parseInt(precedences[0]);
			int atask = Integer.parseInt(precedences[0]);
			adj_matrix[ptask][atask]=1;
		}
		
		HardWeeksSolver slv = new HardWeeksSolver(adj_matrix);
		slv.solve();
		print(slv.answer());
		
		buf.close();

	}
	
	private static void print(String a){
		System.out.println(a);
	}
	private static void print(int a){
		System.out.println(a);
	}

}
