import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.List;
import java.util.LinkedList;
public class Main {

public static void main(String[] args) throws NumberFormatException, IOException,Exception {
			int [] bricks = new int[] {1, 2, 3, 4, 6, 8, 10, 12, 16};

			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String firstInput = input.readLine();
			String[] rows_colums=firstInput.split(" ");
			int rows = Integer.parseInt(rows_colums[0]);
			int colums = Integer.parseInt(rows_colums[1]);
			int[] ways = new int [colums+1];
			ways[0]=1;
			ways[1]=1;

			int W=1;
			number_of_bricks(colums,bricks,ways);
			for (int i=0; i<rows; i++) {
					String aLine=input.readLine();
					List<Integer> q = sequences_of_mosaics(aLine);
					for(Integer el : q){
						   if(el<=1000){
							  
							   W*=ways[el];
							   
						   }
					}
			}
			System.out.println(W);






}


static void number_of_bricks(int colums,int[] bricks,int[] ways){
			
			for(int i = 2; i <= colums; i++){
				for(int j = 0; j < bricks.length && i-bricks[j] >= 0; j++)
					ways[i]+=ways[i-bricks[j]];
			}

		
}

static List<Integer> sequences_of_mosaics(String mosaics) throws Exception {
		List<Integer> queue = new LinkedList<Integer>();
		char[] letters = mosaics.toCharArray();
		int counter = 1;
		char ch = letters[0];
		for (int i = 1; i< letters.length; i++) {
			if(ch=='.') {
				counter=10001;
			}
			if(ch==letters[i]) {
				counter++;
			}else{
				queue.add(counter);
				counter=1;
				ch=letters[i];
			}
		}
		queue.add(counter);
		return queue;
}

}

