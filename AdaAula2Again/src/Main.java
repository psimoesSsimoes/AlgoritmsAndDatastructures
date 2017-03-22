import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {
	public static int MAX =100000+10;
	static int[] alld = new int[MAX];
	static int[] dist_0 = new int[MAX];
	static int[] q = new int[MAX];
	static int[] d = new int[MAX];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));

		StringBuilder ans = new StringBuilder("");
		//capacity
		int weight = Integer.parseInt(buf.readLine());
		//n packages
		int npackages = Integer.parseInt(buf.readLine());
		int[] x = new int[MAX];
		int[] y = new int[MAX];
		int[] w = new int[MAX];
		int[] allw = new int[MAX];
		
		
		//

		for (int i = 1; i <= npackages; i++) {
			StringTokenizer str = new StringTokenizer(buf.readLine());
			x[i]=Integer.parseInt(str.nextToken());
			y[i]=Integer.parseInt(str.nextToken());
			w[i]=Integer.parseInt(str.nextToken());
			
			dist_0[i] = Math.abs(x[i])+Math.abs(y[i]);
			allw[i] = allw[i-1]+w[i];
			alld[i]= alld[i-1] + Math.abs(x[i]-x[i-1])+ Math.abs(y[i]-y[i-1]); 
			
		}
		int f = 1, r = 1;
		for(int i = 1; i<=npackages; i++){
			while(f<=r && allw[i]-allw[q[f]] > weight)
				f++;
			d[i] = func(q[f])+alld[i]+dist_0[i];
			while(f <=r && func(i) <= func(q[r]))
				r--;
			q[++r]=i;
		}
		System.out.println(d[npackages]);
	}
	private static int func(int i){
		return d[i]-alld[i+1]+dist_0[i+1];
	}

}
