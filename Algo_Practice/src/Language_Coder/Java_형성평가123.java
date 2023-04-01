package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_형성평가123 {
	public static void main(String[] args) throws IOException {	
		Scanner sc = new Scanner(System.in);
		String[] str = {"", "dog", "cat", "chick"};
		
		System.out.print("Number? ");
		int n = sc.nextInt();
		
		if(n==1 || n==2 || n==3) {
			System.out.println(str[n]);
		} else {
			System.out.println("I don't know.");
		}
	}
}