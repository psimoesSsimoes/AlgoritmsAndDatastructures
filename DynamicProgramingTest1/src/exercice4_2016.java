
public class exercice4_2016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] b = new int[5][5];
		b[0][0]=7;
		b[1][0]=3;b[1][1]=9;
		b[2][0]=8;b[2][1]=1;b[2][2]=-1;
		b[3][0]=2;b[3][1]=7;b[3][2]=4;b[3][3]=4;
		b[4][0]=0;b[4][1]=5;b[4][2]=2;b[4][3]=-6;b[4][4]=5;
		
		//obter memoria para tablar a funcao
		int[][] c = new int[6][6];
		
		int[][] fc = cal_custos(b,c,1);
		
		printGrid(fc);
	}

	private static int[][] cal_custos(int[][] v, int[][] c, int lvl) {
		if(lvl>v.length)
			return c;
		for(int i=1; i<=lvl;i++){
			c[lvl][i] = v[lvl-1][i-1] + Math.max(c[lvl-1][i-1], c[lvl-1][i]); 
		}
		return cal_custos(v,c,++lvl);
	}
	
	
	/**
	 * given a grid of w or d or m prints that grid
	 * @param a
	 */
	public static void printGrid(int[][] a) {
		/**
		 * int rows = matrix.length; int cols = matrix[0].length;
		 */
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[1].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
