package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_형성평가110 {
	public static void main(String[] args) throws IOException {		
		Scanner sc = new Scanner(System.in);
		double input;
		double yd = 91.44;
		
		System.out.print("yard? ");
		input = sc.nextDouble();
		
		System.out.printf("%.1fyard = %.1fcm", input, input*yd);
	}
}