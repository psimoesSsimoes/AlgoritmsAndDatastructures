package Models;

import java.util.Arrays;

import Utils.Constants;

public class RomanWarfareSolver {
	
	Tuple<Integer, Tuple<Integer, Integer>>[] armies;
	Tuple<Integer, Tuple<Integer, Integer>>[] cities;
	//El[][] grid;
	// following teacher advice we have a matrix for wealth, distance, maintance
	int[][] w, d, m;
	// number of Armies
	int nArmies;
	// number of Cities
	int nCities;

	public RomanWarfareSolver(Tuple<Integer, Tuple<Integer, Integer>>[] armies,
			Tuple<Integer, Tuple<Integer, Integer>>[] cities, int nArmies, int nCities) {
		this.armies = armies;
		this.cities = cities;
		//grid = new El[nArmies + 1][nCities + 1];
		this.nArmies = nArmies;
		this.nCities = nCities;
		w=new int[nArmies+1][nCities+1];
		d=new int[nArmies+1][nCities+1];
		m=new int[nArmies+1][nCities+1];
	}
	/**
	 * Armies and Cities ordered in Ascending order
	 * choose the best between not conquering city with armie ([i-1][j]) and city being conquered by armie ([i-1][j-1]).
	 * That way we can fill the matrixes passing only one time for each position.
	 * The wanted answer is in the last position of each matrix w,d,m
	 * Time complexity  Theta(A*C)   
	 */
	public void solve() {
		for (int i = 1; i <= nArmies; i++) {
			for (int j = 1; j <= nCities; j++) {
				El dg = new El(w[i - 1][j - 1], d[i - 1][j - 1], m[i - 1][j - 1]);
				El nT = new El(dg.w + cities[j - 1].first, dg.d + dist(i - 1, j - 1), dg.m + armies[i - 1].first);
				El pa = new El(w[i - 1][j], d[i - 1][j], m[i - 1][j]);
				if (pa.compareTo(nT)) {
					w[i][j] = nT.w;
					d[i][j] = nT.d;
					m[i][j] = nT.m;
				} else {
					w[i][j] = w[i - 1][j];
					d[i][j] = d[i - 1][j];
					m[i][j] = m[i - 1][j];
				}

			}
		}
		System.out.println(w[nArmies][nCities] + " " + d[nArmies][nCities] + " " + m[nArmies][nCities]);
	}
	

	public void printGrid(El[][] a) {
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

	private int dist(int ai, int pi) {
		return Math.abs(armies[ai].second.first - cities[pi].second.first)
				+ +Math.abs(armies[ai].second.second - cities[pi].second.second);
	}

}
