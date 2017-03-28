import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
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
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
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

		for (int j = 1; j < nCities + 1; j++) {
			String aC = buf.readLine();
			String[] aCv = aC.split(" ");
			cities[j] = new FakeTuple(Integer.parseInt(aCv[0]),
					Integer.parseInt(aCv[1]), Integer.parseInt(aCv[2]));
		}

		Arrays.sort(armies);
		Arrays.sort(cities);
		FakeTuple2[][] fakes = new FakeTuple2[nArmies+1][nCities+1];
		for(int ct=1 ; ct <cities.length; ct++){
			for(int ar=1; ar<armies.length;ar++){
				fakes[ar][ct] = new FakeTuple2(dist(armies[ar],cities[ct]),armies[ar].getM());
			}
		}
		
		printGrid(fakes);

		
		
	}
	/**public static int computeDiagonals(int[][] array){
	    int totalR = 0;
	    int totalD = 0;
	    int totalC = 0;

	    for (int row = 0; row < array.length; row++)
	    {

	        total += array[row][row];
	    }

	    return total;
	}*/
	public static int computeColum(FakeTuple2[] array) {
	    int totalD = array[0].getD();
	    int totalC = array[0].getC();
	    for (int i = 1; i < array.length; i++) {
	        if (array[i].getD() < totalD) {
	            totalD = array[i].getD();
	            totalC = array[i].getC();
	        }
	        else if(array[i].getD() == totalD && array[i].getC()<totalC){
	        	totalD = array[i].getD();
	            totalC = array[i].getC();
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

	public static void printGrid(FakeTuple2[][] a) {
		/**
		 * int rows = matrix.length; int cols = matrix[0].length;
		 */
		for (int i = 1; i < a.length; i++) {
			for (int j = 1; j < a[0].length; j++) {
				System.out.print(a[i][j].toString()+" ");
			}
			System.out.println();
		}
	}
}
