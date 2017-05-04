import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		FileReader fr = null;
		char[][] grid = new char[42][50];
		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("/home/psimoes/test1.txt"));
			
			String[] r_c = br.readLine().split(" ");
			int rows = Integer.parseInt(r_c[0]);
			int colums = Integer.parseInt(r_c[1]);
			String[] lv_n_s = br.readLine().split(" ");
			for (int i = 1; i <= rows; i++){
				grid[i]=br.readLine().toCharArray();
			}
			LionLandSolver slv = new LionLandSolver(grid,rows,colums,lv_n_s);
			print(slv.solution());
			printGrid(grid,rows,colums);
			
			
			
			
			
			

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
	public static void printGrid(char[][] a,int rows,int colums) {
		/**
		 * int rows = matrix.length; int cols = matrix[0].length;
		 */
		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j < colums; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	private static void print(String a){
		System.out.println(a);
}

}
