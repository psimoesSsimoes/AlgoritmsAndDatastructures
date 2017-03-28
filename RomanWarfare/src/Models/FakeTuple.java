package Models;

public class FakeTuple implements Comparable<FakeTuple> {
	public final int x;
	public final int y;
	public int m;

	public FakeTuple(int x, int y, int m) {
		this.x = x;
		this.y = y;
		this.m = m;
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


}
