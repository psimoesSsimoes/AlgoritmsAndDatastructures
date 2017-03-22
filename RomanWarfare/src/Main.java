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
		City[]  cities = new City[Integer.parseInt(ap.split(" ")[1])];
		print(""+armies.length);
		print(""+cities.length);
		for(int i = 0; i < armies.length; i++){
			String aA = buf.readLine();
			armies[i] = new Army(Integer.parseInt(aA.split(" ")[0]),Integer.parseInt(aA.split(" ")[1]),Integer.parseInt(aA.split(" ")[2]));
		}
		for(int j = 0; j < armies.length; j++){
			String aA = buf.readLine();
			cities[j] = new City(Integer.parseInt(aA.split(" ")[0]),Integer.parseInt(aA.split(" ")[1]),Integer.parseInt(aA.split(" ")[2]));
		}
		for(int j = 0; j < armies.length; j++){
			print(armies[j].toString());
			print(cities[j].toString());
		}
	}
	public static void print(String x){
		System.out.println(x);
	}

}
