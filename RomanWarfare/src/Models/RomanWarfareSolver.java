package Models;

import Utils.Constants;

public class RomanWarfareSolver {

	Tuple<Integer, Tuple<Integer, Integer>>[] armies;
	Tuple<Integer, Tuple<Integer, Integer>>[] cities;
    El[][] grid ;
    int nArmies;
    int nCities;
    
	public RomanWarfareSolver(Tuple<Integer, Tuple<Integer, Integer>>[] armies,Tuple<Integer, Tuple<Integer, Integer>>[] cities,int nArmies,int nCities) {
		this.armies=armies;
		this.cities=cities;
		grid = new El[nArmies+1][nCities+1];
		this.nArmies=nArmies;
		this.nCities=nCities;
	}
        public void solve(){
        	
           for (int i = 1; i <= nArmies ;i++){
               for(int j = 1; j<nCities ; j++){
            	   El nT = new El(grid[i-1][j-1].w + cities[j-1].first,grid[i-1][j-1].d + dist(i-1,j-1),grid[i-1][j-1].m +armies[i-1].first);
            	   if(grid[i-1][j].compareTo(nT))
            		   grid[i][j]= grid[i-1][j];
            	   else
            		   grid[i][j]=nT;
            	   
               }
           } 
           printGrid(grid);
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
		return Math.abs(armies[ai].second.first - cities[pi].second.first)+ 
				+ Math.abs(armies[ai].second.second -cities[pi].second.second);
	}

}
