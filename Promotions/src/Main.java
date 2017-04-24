import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	private static final String FILENAME = "/root/workspace/Promotions/promotionsInput";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

			String sCurrentLine;

			String[] fLine = br.readLine().split(" ");
			int A = Integer.parseInt(fLine[0]);
			int B = Integer.parseInt(fLine[1]);
			int N = Integer.parseInt(fLine[2]);
			int P =Integer.parseInt(fLine[3]);
			for(int i = 0; i< P;i++){
				String[] precendences = br.readLine().split(" ");
			}
			
			PromotionsSolver slv = new PromotionsSolver();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
