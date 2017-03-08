import java.util.Arrays;
import java.util.Hashtable;



public class RodCut {

	public static void main(String[] args) {
		int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is "+
                            cut_rod(arr, size));
        System.out.println("Maximum Obtainable Value with dynamic is "+
                cut_rod_dynamic(arr, size));

	}
	//input array of prices and a length of the rope
	//returns maximum possible revenue for given length
	//complexity exponential 2^n and many subproblems solved multiple times
	static int cut_rod(int[] p,int n){
		if(n<=0)
			return 0;
		int q = Integer.MIN_VALUE;
		for(int i = 0; i < n;i++){
			q = Math.max(q, p[i]+cut_rod(p,n-i-1));
		}
		return q;
	}
	//time-memory trade-off
	// save on hash-table computed values
	// check if present before computing (memoized)
	static int cut_rod_dynamic(int[]p,int n){
		Hashtable<Integer,Integer> saved = new Hashtable<Integer,Integer>(n);
		return aux_cut_rod_dynamic(p,n,saved);
	}
	static int aux_cut_rod_dynamic(int[]p,int n,Hashtable<Integer,Integer> saved){
		int q;
		if (saved.contains(n))
			return (int) saved.get(n);
		if (n ==0)
			q=0;
		else{
			q = Integer.MIN_VALUE;
			for(int i = 0; i < n;i++){
				q = Math.max(q, p[i]+aux_cut_rod_dynamic(p,n-i-1,saved));
			}
		}
		saved.put(n, q);
		return q;
	}
	
}
