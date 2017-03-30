import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import Models.RomanWarfareSolver;
import Models.Tuple;
import Utils.Constants;

/**
 * 41839
 * 
 * @author psimoes
 * 
 */

public class Main {

	private static final String FILENAME = "/home/psimoes/gitlab/ADA/romanTest6.txt";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final long startTime = System.nanoTime();
		Tuple<Integer, Tuple<Integer, Integer>>[] armies;
		Tuple<Integer, Tuple<Integer, Integer>>[] cities;
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
			armies = new Tuple[nArmies];
			cities = new Tuple[nCities];

			for (int i = 0; i < nArmies; i++) {
				String aA = br.readLine();
				String[] aAv = aA.split(" ");
				Tuple<Integer, Integer> coord = new Tuple<Integer, Integer>(
						Integer.parseInt(aAv[0]), Integer.parseInt(aAv[1]));
				Tuple<Integer, Tuple<Integer, Integer>> aG = new Tuple<Integer, Tuple<Integer, Integer>>(
						Integer.parseInt(aAv[2]), coord);
				armies[i] = aG;
			}
			for (int j = 0; j < nCities; j++) {
				String aC = br.readLine();
				String[] aCv = aC.split(" ");
				Tuple<Integer, Integer> coord = new Tuple<Integer, Integer>(
						Integer.parseInt(aCv[0]), Integer.parseInt(aCv[1]));
				Tuple<Integer, Tuple<Integer, Integer>> aG = new Tuple<Integer, Tuple<Integer, Integer>>(
						Integer.parseInt(aCv[2]), coord);
				cities[j] = aG;
			}
			
			Arrays.sort(armies, new Comparator<Tuple<Integer,Tuple<Integer,Integer>>>(){
				public int compare(Tuple<Integer,Tuple<Integer,Integer>> o1, Tuple<Integer,Tuple<Integer,Integer>> o2) {
					if (o1 == null && o2 == null) {
			            return 0;
			        }
			        if (o1 == null) {
			            return 1;
			        }
			        if (o2 == null) {
			            return -1;
			        }
			        return o1.first-o2.first;
				}

			});
			
			Arrays.sort(cities, new Comparator<Tuple<Integer,Tuple<Integer,Integer>>>(){
				public int compare(Tuple<Integer,Tuple<Integer,Integer>> o1, Tuple<Integer,Tuple<Integer,Integer>> o2) {
					if (o1 == null && o2 == null) {
			            return 0;
			        }
			        if (o1 == null) {
			            return 1;
			        }
			        if (o2 == null) {
			            return -1;
			        }
			        return o1.first-o2.first;
				}

			});
			System.out.println(System.nanoTime() - startTime);

			RomanWarfareSolver slv = new RomanWarfareSolver(armies, cities,nArmies,nCities);
			slv.solve();
			// compute distances
			final long duration = System.nanoTime() - startTime;
			System.out.println(duration);
		} catch (Exception e) {
			e.printStackTrace();
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
