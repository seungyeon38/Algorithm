package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_형성평가164_틀림 {
	public static void main(String[] args) throws IOException {	
		Scanner sc = new Scanner(System.in);
		
		int sum;
		int[] arr = new int[5];
		for(int i=1; i<5; i++) {
			System.out.print(i+"class?");
			sum = 0;
			for(int j=0; j<3; j++) {
				sum += sc.nextInt();
			}
			arr[i] = sum;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<5; i++) {
			sb.append(i).append("class : ").append(arr[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

