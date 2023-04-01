package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_형성평가161 {
	public static void main(String[] args) throws IOException {	
		Scanner sc = new Scanner(System.in);
		int n;
		int[] arr = new int[11];
		while((n = sc.nextInt()) != 0) {
			arr[n/10]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=10; i>=0; i--) {
			if(arr[i] != 0) sb.append(i*10).append(" : ").append(arr[i]).append(" person").append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

