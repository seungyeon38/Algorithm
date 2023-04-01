package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_자가진단633 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		Scanner sc = new Scanner(System.in);
		String[] capital = {"", "Seoul", "Washington", "Tokyo", "Beijing"};

		System.out.println("1. Korea");
		System.out.println("2. USA");
		System.out.println("3. Japan");
		System.out.println("4. China");
		System.out.print("number?");			
		int n = sc.nextInt();
		
		while(n==1 || n==2 || n==3 || n==4) {			
			System.out.println();
			System.out.println(capital[n]);
			System.out.println();
			
			System.out.println("1. Korea");
			System.out.println("2. USA");
			System.out.println("3. Japan");
			System.out.println("4. China");
			System.out.print("number?");			
			n = sc.nextInt();
		}
		
		System.out.println();
		System.out.println("none");
	}
}