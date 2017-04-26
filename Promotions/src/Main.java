import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;

public class Main {
	private static final String FILENAME = "/home/psimoes/gitlab/ADA/promotionsInput.txt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			
			Map<Integer,Queue<Integer>> a1 = new HashMap<Integer,Queue<Integer>>(5001);
			
			Map<Integer,Queue<Integer>> a2 = new HashMap<Integer,Queue<Integer>>(5001);
			// String sCurrentLine;

			String[] fLine = br.readLine().split(" ");
			int A = Integer.parseInt(fLine[0]);
			int B = Integer.parseInt(fLine[1]);
			int N = Integer.parseInt(fLine[2]);
			int P = Integer.parseInt(fLine[3]);

			while (--P > 0) {
				String[] precedences = br.readLine().split(" ");
				int x = Integer.parseInt(precedences[0]);
				int y = Integer.parseInt(precedences[1]);

				try{
					a1.get(x).offer(y);
					
				}catch(Exception e){
					//System.out.println(e);
					Queue<Integer> e2 = new LinkedList<Integer>();
					e2.offer(y);
					a1.put(x, e2);
				}

				try{
					a2.get(y).offer(x);
				}catch(Exception e){
					//System.out.println(e);
					Queue<Integer> e2 = new LinkedList<Integer>();
					e2.offer(x);
					a2.put(y, e2);
				}

			}

			PromotionsSolver slv = new PromotionsSolver(a1, a2, N, A, B);
			System.out.println(slv.answer());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
