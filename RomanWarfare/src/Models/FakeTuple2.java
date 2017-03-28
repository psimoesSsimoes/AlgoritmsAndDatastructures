package Models;

public class FakeTuple2 {
	private int d;
	private int c;
	public FakeTuple2(int d,int c){
		this.setD(d);
		this.setC(c);
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public String toString(){
		return "("+c +","+d+")";
	}
	
}
