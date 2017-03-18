import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.List;
import LegoSolver;

public class Main {

public static void main(String[] args) throws NumberFormatException, IOException,Exception {

			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			InputStreamReader(System.in));
			String[] board = input.readLine().split(" ");
			LegoSolver solver = new LegoSolver(Integer.parseInt(board[1]));
			for (int i = 0 ; i < Integer.parseInt(board[0]) ; i++)
				solver.processLine(input.readLine());
			input.close();
			System.out.println(solver.getNrCombinations());
}








static void number_of_bricks(int colums,int[] bricks,int[] ways){

			for(int i = 1; i <= colums; i++){
				for(int j = 0; j < bricks.length && i-bricks[j] >= 0; j++)
					ways[i]+=ways[i-bricks[j]];
			}


}


}
