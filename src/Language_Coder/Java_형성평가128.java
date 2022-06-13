package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_형성평가128 {
	public static void main(String[] args) throws IOException {	
		Scanner sc = new Scanner(System.in);
		
		int n;
		int result = 0;
		while((n = sc.nextInt()) != 0) {
			if(n%3 != 0 && n%5 != 0) {
				result++;
			}
		}
		
		System.out.println(result);
	}
}