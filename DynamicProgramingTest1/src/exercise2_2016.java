
public class exercise2_2016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] X = new int[]{0,2,4,6};
		int y = 3;
		
		System.out.println(funcao(X,y,X.length,1));
	}

	private static int funcao(int[] X, int y, int n, int wj) {
		
		//obter memoria para tabelar a funcao
		int[][] table = new int[n+1][2];
		int i = 0;
		
		//tratar bases da recursividade
		while(i<y){
			for(int d = 0; d<=1;d++){
				table[i][d] = 0;
			}
			i++;
		}
		//tratar caso geral
		
		for(i=y;i<=n;i++){
			for (int j=0;j<=1;j++){
				table[i][j] = Integer.MIN_VALUE;
				switch(j){
					case 0:
						for(int k=1; k<=y;k++){
							int value = table[i-k][1]+X[i-k];
							if(value> table[i][j])
								table[i][j]=value;
						}
						break;
					case 1:
						for(int k=1; k<=y;k++){
							int value = table[i-k][0]-X[i-k];
							if(value> table[i][j])
								table[i][j]=value;
						}
						break;
				}
				
			}
			
			
		}
		
		printGrid(table);
		
		return table[n][wj];
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
