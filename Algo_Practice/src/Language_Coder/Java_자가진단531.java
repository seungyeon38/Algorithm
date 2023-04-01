package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_자가진단531 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double w = Double.parseDouble(br.readLine());
		
		if(w <= 50.80) {
			System.out.println("Flyweight");
		} else if(w <= 61.23) {
			System.out.println("Lightweight");
		} else if(w <= 72.57) {
			System.out.println("Middleweight");
		} else if(w <= 88.45) {
			System.out.println("Cruiserweight");
		} else {
			System.out.println("Heavyweight");
		}
	}
}