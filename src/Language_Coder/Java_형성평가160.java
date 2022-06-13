package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_형성평가160 {
	public static void main(String[] args) throws IOException {	
		int[] arr = new int[7];
	
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<10; i++) {
			arr[sc.nextInt()]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<7; i++) {
			sb.append(i).append(" : ").append(arr[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

