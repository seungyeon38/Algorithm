package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_형성평가126 {
	public static void main(String[] args) throws IOException {	
		Scanner sc = new Scanner(System.in);
		
		int n;
		int odd_n = 0;
		int even_n = 0;
		
		while((n = sc.nextInt())!=0) {
			if(n%2 == 0) {
				even_n++;
			} else {
				odd_n++;
			}
		}
		
		System.out.println("odd : "+odd_n);
		System.out.println("even : "+even_n);
	}
}