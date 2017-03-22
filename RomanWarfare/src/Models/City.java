package Models;

public class City {
	int x,y,w;
	
	public City(int x, int y, int w){
		this.x = x;
		this.y = y;
		this.w = w;
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
	
	public String toString(){
		return this.x + " "+ this.y+ " "+this.w;
	}
}
