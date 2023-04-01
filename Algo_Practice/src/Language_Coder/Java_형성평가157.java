package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_형성평가157 {
	public static void main(String[] args) throws IOException {	
		Scanner sc = new Scanner(System.in);
		
		int n;
		int sum = 0;
		int num = 0;
		while((n=sc.nextInt()) != 0) {
			if(n%5 == 0) {
				sum += n;
				num++;
			}
		}
		
		System.out.println("Multiples of 5 : "+num);
		System.out.println("sum : "+sum);
		System.out.printf("avg : %.1f", (double)sum/num);
	}
}

