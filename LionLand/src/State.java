
public class State {
	private int lx;
	private int ly;
	private int gx;
	private int gy;


	public State(int lx, int ly, int gx, int gy) {
		this.setLx(lx);
		this.setLy(ly);
		this.setGx(gx);
		this.setGy(gy);
	}

	public int getLx() {
		return lx;
	}

	public void setLx(int lx) {
		this.lx = lx;
	}

	public int getLy() {
		return ly;
	}

	public void setLy(int ly) {
		this.ly = ly;
	}

	public int getGx() {
		return gx;
	}

	public void setGx(int gx) {
		this.gx = gx;
	}

	public int getGy() {
		return gy;
	}

	public void setGy(int gy) {
		this.gy = gy;
	}
	
	public String toString(){
		return gx+" "+gy+" "+lx +" "+ly;
	}
}
