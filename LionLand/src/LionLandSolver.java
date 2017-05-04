import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LionLandSolver {

	char[][][][] visited = new char[42][42][42][42];
	Deque<State> Q = new LinkedList<State>();
	Deque<Integer> DQ = new LinkedList<Integer>();
	private char[][] grid;
	private int rows;
	private int colums;
	int lx, ly, gx, gy, mx, my;

	int f;

	final int dx[] = { 0, 0, 1, -1 };
	final int dy[] = { 1, -1, 0, 0 };
	final int ox[] = { 0, 0, 1, -1 };
	final int oy[] = { -1, 1, 0, 0 };

	public LionLandSolver(char[][] grid, int rows, int colums, String[] lv_n_s) {
		this.grid = grid;
		this.rows = rows;
		this.colums = colums;
		this.mx = Integer.parseInt(lv_n_s[0])-1;
		this.my = Integer.parseInt(lv_n_s[1])-1;
		this.gx = Integer.parseInt(lv_n_s[2])-1;
		this.gy = Integer.parseInt(lv_n_s[3])-1;
		this.lx = Integer.parseInt(lv_n_s[4])-1;
		this.ly = Integer.parseInt(lv_n_s[5])-1;
	}

	public String solution() {
		f=bfs();
		if (f == -1)
			return "NO LOVE";
		else
			return f + "";
	}

	public int bfs() {
		visited[lx][ly][gx][gy] = 1;
		Q.add(new State(lx, ly, gx, gy)); DQ.add(0);
		if (lx == gx && ly == gy && lx == mx && ly == my)
			return 0;
		while (!Q.isEmpty()) {
			State u = Q.peek();
			Integer d = new Integer(DQ.peek());
			Q.pop();DQ.pop();
			
			for (int i = 0; i < 4; i++) {
				
				//State v = u; this cannot be like this because you're copying object references
				State v = new State(u.getLx(),u.getLy(),u.getGx(),u.getGy());
				int tx, ty;
				tx = v.getLx() + dx[i];ty = v.getLy() + dy[i];
				
				if (tx >= 0 && ty >= 0 && tx < rows && ty < colums && grid[tx][ty] == '.'){
					v.setLx(tx); v.setLy(ty);
					
				}
					
				tx = v.getGx() + ox[i]; ty = v.getGy() + oy[i];
				
				if (tx >= 0 && ty >= 0 && tx < rows && ty < colums && grid[tx][ty] == '.'){
					v.setGx(tx); v.setGy(ty);
				}
				
				if (v.getLx() == v.getGx() && v.getLy() == v.getGy() && v.getLx() == mx && v.getLy() == my)
					return d+1;
				
				if (visited[v.getLx()][v.getLy()][v.getGx()][v.getGy()]== 0) {
					visited[v.getLx()][v.getLy()][v.getGx()][v.getGy()] = 1;
					visited[v.getGx()][v.getGy()][v.getLx()][v.getLy()] = 1;
					Q.push(v);DQ.push(d+1);
				}
				
			}
			Q.peek();
			
		}
		
		return -1;
	}
}
