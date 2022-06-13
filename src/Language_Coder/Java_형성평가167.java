package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_형성평가167 {
	public static void main(String[] args) throws IOException {	
		int[][] arr = new int[4][2];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int sum;
		for(int i=0; i<4; i++) {
			sum = 0;
			for(int j=0; j<2; j++) {
				sum += arr[i][j];
			}
			sb.append(sum/2).append(" ");
		}
		sb.append("\n");
		
		for(int i=0; i<2; i++) {
			sum = 0;
			for(int j=0; j<4; j++) {
				sum += arr[j][i];
			}
			sb.append(sum/4).append(" ");
		}
		sb.append("\n");

		sum = 0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<2; j++) {
				sum += arr[i][j];
			}
		}
		sb.append(sum/8);
		
		System.out.println(sb.toString());
	}
}

