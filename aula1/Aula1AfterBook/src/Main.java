import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Queue;
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

								int W=-1;
								for (int i=0; i<rows; i++) {
																String aLine=input.readLine();
																Queue q = sequences_of_mosaics(aLine);
																q.forEach(z->{
																																		if(z<=1000)
																																										W+=number_of_bricks(z,bricks,ways);
																										});

								}
								System.out.println(W);






}


static int number_of_bricks(int colums,int[] bricks,int[] ways){
								if(ways.length-1>=colums)
																return ways[colums-1];
								else{
																for(int i = ways.length; i <= colums; i++)
																								for(int j = 0; j < bricks.length && i-bricks[j] >= 0; j++)
																																ways[i]+=ways[i-bricks[j]];

																return ways[colums-1];
								}
}

static Queue<Integer> sequences_of_mosaics(String mosaics) throws Exception {

								Queue<Integer> queue = new LinkedList<Integer>();
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
