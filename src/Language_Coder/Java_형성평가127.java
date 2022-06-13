package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_형성평가127 {
	public static void main(String[] args) throws IOException {	
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum = 0;
		int num = 0;
		
		while(n>=0 && n<=100) {
			sum += n;
			num++;
			n = sc.nextInt();
		}
		
		System.out.println("sum : "+sum);
		System.out.printf("avg : %.1f",(double)sum/num);
	}
}