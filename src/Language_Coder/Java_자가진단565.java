package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_자가진단565 {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		Scanner sc = new Scanner(System.in);
		int n;
		int[] arr = new int[10];
		
		while((n=sc.nextInt()) != 0) {
			arr[n/10]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<10; i++) {
			if(arr[i] != 0) sb.append(i).append(" : ").append(arr[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}