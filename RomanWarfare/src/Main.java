import java.io.BufferedReader;
import java.io.FileReader;
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
	// two-dimen for dist armie city
	static int[][] dist;
	static FakeTuple[] cities;
	static FakeTuple[] armies;
	static int max_profit = 0;
	static int[] ct_w;
	private static final String FILENAME = "/home/psimoes/gitlab/ADA/romanTest3.txt";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final long startTime = System.nanoTime();
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));

		// exercitos-populacao
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			

			br = new BufferedReader(new FileReader(FILENAME));

			String ap = br.readLine();

			int nArmies = Integer.parseInt(ap.split(" ")[0]);
			int nCities = Integer.parseInt(ap.split(" ")[1]);

			// space for ct_w
			ct_w = new int[nCities + 1];

			for (int i = 1; i < nArmies + 1; i++) {
				String aA = br.readLine();
				String[] aAv = aA.split(" ");

			}
			for (int j = 1; j < nCities + 1; j++) {
				String aC = br.readLine();
				String[] aCv = aC.split(" ");
				ct_w[j] = Integer.parseInt(aCv[2]);
			}
			//sortArrays of ct_w and
			Arrays.sort(ct_w);
			// calculate max profit
			if (nCities > nArmies) {
				for (int i = nCities; i > nCities-nArmies; i--) {
					max_profit += ct_w[i];
				}
			} else {
				for (int i = 1; i <= nCities; i++) {
					max_profit += ct_w[i];
				}
			}

			print("max profit of:" + max_profit);
		} catch (Exception e) {

		}
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
