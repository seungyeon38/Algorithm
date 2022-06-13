package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_자가진단538 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("number? ");
		int n = sc.nextInt();
		
		while(n != 0) {
			if(n > 0) {
				System.out.println("positive integer");
			} else if(n < 0) {
				System.out.println("negative number");
			}
			System.out.print("number? ");
			n = sc.nextInt();
		}
	}
}