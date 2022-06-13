package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_자가진단540 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		Scanner sc = new Scanner(System.in);
		int n;
		
		while((n = sc.nextInt()) != -1) {
			if(n%3 == 0) {
				System.out.println(n/3);
			}
		}
	}
}