import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import Models.RomanWarfareSolver;


public class Main {

	public static int MAX_D =10000+10;
	public static int MAX_A_C =4000+10;
	public static int MAX_M_W =10000+10;
	static int[] d = new int[MAX_D];
	static int[] x_a ;
	static int[] y_a;
	static int[] y_c;
	static int[] x_c;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));

		//exercitos-populacao
		String ap = buf.readLine();
		
		
		
		int nArmies = Integer.parseInt(ap.split(" ")[0]);
		int nCities = Integer.parseInt(ap.split(" ")[1]);
		x_a = new int[nArmies+2];
		y_a = new int[nArmies+2];
		y_c = new int[nCities+2];
		x_c = new int[nCities+2];
		int[] m = new int[nArmies+1];
		int[] w = new int[nCities+1];
		int[][] a_c = new int[nArmies+2][nCities+2];
		
		for(int i = 2; i < nArmies+2; i++){
			String aA = buf.readLine();
			String[] aAv = aA.split(" ");
			x_a[i]=Integer.parseInt(aAv[0]);
			y_a[i]=Integer.parseInt(aAv[1]);
			a_c[i][0]= Integer.parseInt(aAv[2]);//keep maintance values on colum 0
			a_c[i][1] = i;//keep index for manhatan coord on colum 1
			print(Arrays.toString(x_a));
		}
		
		for(int j = 2; j < nCities+2; j++){
			String aC = buf.readLine();
			String[] aCv = aC.split(" ");
			x_c[j]=Integer.parseInt(aCv[0]);
			y_c[j]=Integer.parseInt(aCv[1]);
			a_c[0][j]=Integer.parseInt(aCv[2]);//keep wealth values on row 0
			a_c[1][j] = j;//keep index for manhatan coord on colum 1
			print(Arrays.toString(x_c));
		}
		
		int min = Integer.MAX_VALUE;
		int previous_value;
		
		printGrid(a_c);
		int[] cty = new int[nCities];
		
	}
		
	private static int dist(int i, int c) {
		
		return Math.abs(x_a[i]-x_c[c]) + Math.abs(y_a[i]-y_c[c]);
	}
	public static void print(String x){
		System.out.println(x);
	}
	public static void printGrid(int[][] a)
	{
	   for(int i = 0; i < 5; i++)
	   {
	      for(int j = 0; j < 4; j++)
	      {
	         System.out.printf("%5d ", a[i][j]);
	      }
	      System.out.println();
	   }
	}
}
