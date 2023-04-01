package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_자가진단514 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		int height;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("height = ");
		height = sc.nextInt();
		
		System.out.printf("Your height is %dcm.", height);
	}
}