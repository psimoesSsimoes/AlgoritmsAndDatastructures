import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import packageA.Point;
import packageA.RobotTruckSolver;




public class Main {

	private static Point[] p;
	private static int[] sumw;
	private static int[] sumd;
	private static Point a;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));

		StringBuilder ans = new StringBuilder("");
		//capacity
		int weight = Integer.parseInt(buf.readLine());
		//n packages
		int npackages = Integer.parseInt(buf.readLine());
		p = new Point[10001];
		Arrays.fill(p, new Point(0,0,0,0));
		//fill position 0
		sumw = new int[10001];
		sumd = new int[10001];
		for (int i = 1; i <= npackages; i++) {
			StringTokenizer str = new StringTokenizer(buf.readLine());
			a = new Point(); 
			a.setX(Integer.parseInt(str.nextToken()));
			a.setY(Integer.parseInt(str.nextToken()));
			a.setW(Integer.parseInt(str.nextToken()));
			a.setD( distancia( a, p[0] ) );
			p[i]=a;
			sumw[i]= sumw[i-1] + a.getW();
			sumd[i]= sumd[i-1] + distancia(p[i],p[i-1]);
		}
		
		RobotTruckSolver slv = new RobotTruckSolver(p,sumw,sumd,npackages,weight);
		System.out.println(slv.solve());
	}
	private static int distancia(Point a, Point b){
		return Math.abs(a.getX()-b.getX()) + Math.abs(a.getY()-b.getY());
	}

}
