import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Models.Army;
import Models.City;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));

		//exercitos-populacao
		String ap = buf.readLine();
		Army[] armies = new Army[Integer.parseInt(ap.split(" ")[0])];
		City[]  city = new City[Integer.parseInt(ap.split(" ")[1])];
		print(""+armies.length);
		print(""+armies.length);
		
	}
	public static void print(String x){
		System.out.println(x);
	}

}
