package Models;

public class El {
	int w;
	int d;
	int m;
	public El(){
		w=0;
	}
	public El(int w,int d, int m){
		this.w=w;
		this.d=d;
		this.m=m;
	}
	public boolean compareTo(El e){
		if(w!=e.w) return w<e.w;
		if(d!=e.d) return d>e.d;
		return m>e.m;
	}
	public String toString(){
		return w+" "+d+" "+m;
	}
}
