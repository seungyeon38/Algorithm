package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_형성평가156 {
	public static void main(String[] args) throws IOException {	
		Scanner sc = new Scanner(System.in);
		
		int n;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		while((n=sc.nextInt()) != 999) {
			max = Math.max(max, n);
			min = Math.min(min, n);
		}
		
		System.out.println("max : "+max);
		System.out.println("min : "+min);
	}
}

