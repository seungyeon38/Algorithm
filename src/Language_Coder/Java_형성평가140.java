package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_형성평가140 {
	public static void main(String[] args) throws IOException {	
		Scanner sc = new Scanner(System.in);
		
		int n;
		int sum = 0;
		int num = 0;

		for(int i=0; i<20; i++) {
			n = sc.nextInt();
			
			if(n == 0) break; 
			sum += n;
			num++;
		}
		
		System.out.println(sum + " " + sum/num);
	}
}