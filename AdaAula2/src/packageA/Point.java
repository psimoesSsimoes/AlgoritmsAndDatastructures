package packageA;


public class Point {
	private int x;
	private int y;
	private int w;
	private int d;
	
	
	public Point(){
		
	}
	
	public Point(int x, int y, int w, int d){
		this.setX(x);
		this.setY(y);
		this.setW(w);
		this.setD(d);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}
}
