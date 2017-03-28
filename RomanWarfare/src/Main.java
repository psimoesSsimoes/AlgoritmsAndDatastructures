import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import Models.FakeTuple;
import Models.FakeTuple2;

/**
 * 41839
 * 
 * @author psimoes
 * 
 */

public class Main {

	public static int MAX_D = 10000 + 10;
	public static int MAX_A_C = 4000 + 10;
	public static int MAX_M_W = 10000 + 10;
	//two-dimen for dist armie city
	static int[][] dist;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final long startTime = System.nanoTime();
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));

		// exercitos-populacao
		String ap = buf.readLine();

		int nArmies = Integer.parseInt(ap.split(" ")[0]);
		int nCities = Integer.parseInt(ap.split(" ")[1]);
		
		FakeTuple[] armies = new FakeTuple[nArmies + 1];
		FakeTuple[] cities = new FakeTuple[nCities + 1];
		armies[0] = new FakeTuple(0, 0, 0);
		cities[0] = new FakeTuple(0, 0, 0);

		for (int i = 1; i < nArmies + 1; i++) {
			String aA = buf.readLine();
			String[] aAv = aA.split(" ");
			armies[i] = new FakeTuple(Integer.parseInt(aAv[0]),
					Integer.parseInt(aAv[1]), Integer.parseInt(aAv[2]));
		}
		int totalR=0;
		for (int j = 1; j < nCities + 1; j++) {
			String aC = buf.readLine();
			String[] aCv = aC.split(" ");
			cities[j] = new FakeTuple(Integer.parseInt(aCv[0]),
					Integer.parseInt(aCv[1]), Integer.parseInt(aCv[2]));
			totalR+=Integer.parseInt(aCv[2]);
		}

		Arrays.sort(armies);
		Arrays.sort(cities);
		dist = new int[nArmies + 1][nCities + 1];
		for (int ct = 1; ct < cities.length; ct++) {
			for (int ar = 1; ar < armies.length; ar++) {
				dist[ar][ct] = dist(armies[ar], cities[ct]);
			}
		}
		printGrid(dist);
		//print(computeColum(fakes,1).toString());
		FakeTuple2[] f = new FakeTuple2[cities.length];
		int totalD = Integer.MAX_VALUE, totalC = Integer.MAX_VALUE;
		int arf=nArmies;
		int ari=nArmies-nCities+1;
		/**
		while(ari>0){
			f[nCities]=fakes[arf][nCities];
			FakeTuple2[] result = computealldiagonals(fakes, f, ari,
					arf, nCities-1);
			
			int tD=0,tC=0;
			
			//Arrays.toString(result);
			for(int i =1;i<result.length;i++){
				tD+=result[i].getD();
				tC+=result[i].getC();
			}
			if(tD<=totalD){
				totalD=tD;
				if(tC<totalC)
					totalC=tC;
			}
			ari--;
			arf--;
			
		}
		*/
		
		print(totalR+" "+totalD + " "+totalC);

	}

	private static FakeTuple2[] computealldiagonals(FakeTuple2[][] fakes,
			FakeTuple2[] f, int ari, int arf, int ct) {

		if (ct == 0)
			return f;
		else {
			f[ct] = computeColum(fakes,ari-1,arf-1, ct);
			return computealldiagonals(fakes, f, ari, arf, ct - 1);
		}

	}

	public static FakeTuple2 computeColum(FakeTuple2[][] array,int ari,int arf, int colum) {
		FakeTuple2 totalD = array[1][colum];
		if(ari==0)
			ari=1;
		
		for (int i = ari; i <=arf; i++) {
			if (array[i][colum].getD() < totalD.getD()) {
				totalD = array[i][colum];

			} else if (array[i][colum].getD() == totalD.getD()
					&& array[i][colum].getC() < totalD.getC()) {
				totalD = array[i][colum];
			}
		}
		return totalD;
	}

	private static int dist(FakeTuple a, FakeTuple c) {
		// TODO Auto-generated method stub
		return Math.abs(a.getX() - c.getX()) + Math.abs(a.getY() - c.getY());
	}

	public static void print(String x) {
		System.out.println(x);
	}

	public static void printGrid(int[][] a) {
		/**
		 * int rows = matrix.length; int cols = matrix[0].length;
		 */
		for (int i = 1; i < a.length; i++) {
			for (int j = 1; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
