import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import Models.FakeTuple;
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
		x_a = new int[nArmies+1];
		y_a = new int[nArmies+1];
		y_c = new int[nCities+1];
		x_c = new int[nCities+1];
		int[] bs = new int[nCities+1];
		int[][] a_c = new int[nArmies+2][nCities+2];
		FakeTuple[] a = new FakeTuple[nArmies+1];
		for(int i = 1; i < nArmies+1; i++){
			String aA = buf.readLine();
			String[] aAv = aA.split(" ");
			x_a[i]=Integer.parseInt(aAv[0]);
			y_a[i]=Integer.parseInt(aAv[1]);
			a_c[i][0]= Integer.parseInt(aAv[2]);//
			
		}
		
		for(int j = 1; j < nCities+1; j++){
			String aC = buf.readLine();
			String[] aCv = aC.split(" ");
			x_c[j]=Integer.parseInt(aCv[0]);
			y_c[j]=Integer.parseInt(aCv[1]);
			a_c[0][j]=Integer.parseInt(aCv[2]);//keep wealth values on row 0
			print(Arrays.toString(x_c));
		}
		
		
		//minDistance to from army to city
		int mD=Integer.MAX_VALUE;
		int maxR=0,minD=0,minC=0;
		int lastM=Integer.MAX_VALUE;
		int tD;
		int tC=Integer.MAX_VALUE;
		int ttD=Integer.MAX_VALUE;
		for(int ct = 1 ; ct < nCities+1 ; ct++){
			for (int ar = 1; ar < nArmies+1; ar++){
				if(a_c[ar][0] >= a_c[0][ct] && (ttD = Math.min(dist(ar,ct),mD))<=mD ){
					if(ttD==mD){
						if(tC > a_c[ar][0]){
							
						}
						
					}else{
						mD=ttD;
					}
				}
			}
			maxR+=a_c[0][ct];
			minD+=mD
			
		}
		printGrid(a_c);
		int[] cty = new int[nCities];
		
	}
		
	private static int dist(int i, int c) {
		
		return Math.abs(x_a[i]-x_c[c]) + Math.abs(y_a[i]-y_c[c]);
	}
	private static char min(int f,int s){
		if(f<s)
			return 'f';
		else if(f > s)
			return 's';
		else
			return 't';
		
	}
	public static void print(String x){
		System.out.println(x);
	}
	public static void printGrid(int[][] a)
	{
		/**
		 * int rows = matrix.length;
int cols = matrix[0].length;
		 */
	   for(int i = 0; i < a.length; i++)
	   {
	      for(int j = 0; j < a[0].length; j++)
	      {
	         System.out.printf("%5d ", a[i][j]);
	      }
	      System.out.println();
	   }
	}
}
