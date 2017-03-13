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
			int W=1;

			//number_of_bricks(colums,bricks,ways);
			String[] board = new String[rows];
			for (int i=0; i<rows; i++) {
					String aLine=input.readLine();
					board[i]=aLine;
			}
			int[] all = new int[rows*colums];
			int[] seq_mosaic = all_seq_mosaics(board,all);
			//System.out.println(Arrays.toString(seq_mosaic));

			//calculate max of Array
			int max = Arrays.stream(seq_mosaic).max().getAsInt();
			//System.out.println(max);
			number_of_bricks(colums, bricks, ways);
			// calculate number of bricks to max of Array
			for(int j = 0; j < seq_mosaic.length; j++){
				W*=ways[seq_mosaic[j]];
			}


			System.out.println(W);
}








static void number_of_bricks(int colums,int[] bricks,int[] ways){

			for(int i = 1; i <= colums; i++){
				for(int j = 0; j < bricks.length && i-bricks[j] >= 0; j++)
					ways[i]+=ways[i-bricks[j]];
			}


}

static int[] all_seq_mosaics(String[] mosaics,int[] all){
	int index=0;
	for (int k = 0; k<mosaics.length;k++){
		int counter = 1;
		char ch = mosaics[k].charAt(0);
		for (int i = 1; i < mosaics[k].length(); i++) {
			if(ch=='.') {
					counter = Integer.MIN_VALUE;
			}
			if(mosaics[k].charAt(i) == ch) {
					counter++;
			}else{
					all[index]=counter;
					counter=1;
					ch=mosaics[k].charAt(i);
					index++;
			}
		}

	all[index++]=counter;
	}
	return Arrays.stream(all).filter(x -> x > 0).toArray();
}


/**
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
*/
}
