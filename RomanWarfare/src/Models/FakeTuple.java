package Models;

public class FakeTuple implements Comparable<FakeTuple> {
	public final int x;
	public final int y;
	public int m;
	private int d;

	public FakeTuple(int x, int y, int m,int d) {
		this.x = x;
		this.y = y;
		this.m = m;
		this.setD(d);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public int getM() {
		return m;
	}
	public String toString(){
		return ""+m;
	}
	
	public int compareTo(FakeTuple another) {
        return this.m - another.m;
    }

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}


}
