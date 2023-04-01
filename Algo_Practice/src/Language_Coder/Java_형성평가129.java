package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_형성평가129 {
	public static void main(String[] args) throws IOException {	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Base = ");
		int base = sc.nextInt();
		
		System.out.print("Height = ");
		int height = sc.nextInt();
		
		System.out.printf("Triangle width = %.1f\n", 0.5*base*height);
		
		System.out.print("Continue? ");
		char ans = sc.next().charAt(0);
		
		while(ans == 'Y' || ans == 'y') {
			System.out.print("Base = ");
			base = sc.nextInt();
			
			System.out.print("Height = ");
			height = sc.nextInt();
			
			System.out.printf("Triangle width = %.1f\n", 0.5*base*height);
			
			System.out.print("Continue? ");
			ans = sc.next().charAt(0);
		}
	}
}