package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_자가진단564 {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		int min = 'A';
		int max = 'Z';
		
		int[] arr = new int[max+1];
		
		Scanner sc = new Scanner(System.in);
		int n; 
		
		while((n=sc.next().charAt(0))>=min && n<=max) {
			arr[n]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=min; i<=max; i++) {
			if(arr[i] != 0) {
				sb.append((char)i).append(" : ").append(arr[i]).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}