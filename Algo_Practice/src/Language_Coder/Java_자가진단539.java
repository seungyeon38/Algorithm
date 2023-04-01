package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_자가진단539 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		Scanner sc = new Scanner(System.in);
		int n;
		int sum = 0;
		int num = 0;
		while((n = sc.nextInt()) < 100) {
			sum += n;
			num++;
		}
		sum += n;
		
		System.out.println(sum);
		System.out.printf("%.1f", (double)sum/++num);
	}
}