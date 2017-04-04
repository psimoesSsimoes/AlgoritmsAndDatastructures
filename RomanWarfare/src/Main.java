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
 * 
 * Objetives: Max conquered Value
 * 			  Min covered distance
 * 			  in case of tie, min the cost
 * 
 * Premises : 2 armies with increasing cost can only attack cities with also incresing cost
 * 			  if an armie has attacked certain city that cost < can only attack cities worth <
 * 			  if an armie has attacked certain city taht cost > can only attack cities worth >
 * 			  no armie or cities have the same location
 * 			  positions of armies and cities in manhattan matter
 * 
 * @author pedro simoes 41656 diogo rodrigues 41839
 * 
 */

public class Main {

	


	public static void main(String[] args) throws IOException {
		
		/**
		 * an Array of Tuple armies. Each armie has the structure (m,(x,y))
		 */
		Tuple<Integer, Tuple<Integer, Integer>>[] armies;
		/**
		 * an Array of Tuple cities. Each citie has the structure (w,(x,y))
		 */
		Tuple<Integer, Tuple<Integer, Integer>>[] cities;
		

		

		try {
			BufferedReader buf = new BufferedReader(
					new InputStreamReader(System.in));
		

			String ap = buf.readLine();

			int nArmies = Integer.parseInt(ap.split(" ")[0]);
			int nCities = Integer.parseInt(ap.split(" ")[1]);
			
			armies = new Tuple[nArmies];
			cities = new Tuple[nCities];
			/**
			 * read values for armies
			 */
			for (int i = 0; i < nArmies; i++) {
				String aA = buf.readLine();
				String[] aAv = aA.split(" ");
				Tuple<Integer, Integer> coord = new Tuple<Integer, Integer>(
						Integer.parseInt(aAv[0]), Integer.parseInt(aAv[1]));
				Tuple<Integer, Tuple<Integer, Integer>> aG = new Tuple<Integer, Tuple<Integer, Integer>>(
						Integer.parseInt(aAv[2]), coord);
				armies[i] = aG;
			}
			/**
			 * read values for cities
			 */
			for (int j = 0; j < nCities; j++) {
				String aC = buf.readLine();
				String[] aCv = aC.split(" ");
				Tuple<Integer, Integer> coord = new Tuple<Integer, Integer>(
						Integer.parseInt(aCv[0]), Integer.parseInt(aCv[1]));
				Tuple<Integer, Tuple<Integer, Integer>> aG = new Tuple<Integer, Tuple<Integer, Integer>>(
						Integer.parseInt(aCv[2]), coord);
				cities[j] = aG;
			}
			/**
			 * Order them based on the maintance value. Ascending order
			 * Time-Cost Theta(A)  
			 */
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
			/**
			 * Order them based on the wealth value. Ascending order
			 * Time-Cost Theta(C)  
			 */
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
			//System.out.println(System.nanoTime() - startTime);

			RomanWarfareSolver slv = new RomanWarfareSolver(armies, cities,nArmies,nCities);
			slv.solve();
			
			//final long duration = System.nanoTime() - startTime;
			//System.out.println(duration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void print(String x) {
		System.out.println(x);
	}
	/**
	 * given a grid of w or d or m prints that grid
	 * @param a
	 */
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
