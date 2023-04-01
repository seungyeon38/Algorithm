package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_형성평가166 {
	public static void main(String[] args) throws IOException {	
		int[][] arr1 = new int[2][3];
		int[][] arr2 = new int[2][3];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("first array");
		for(int i=0; i<2; i++) {
			for(int j=0; j<3; j++) {
				arr1[i][j] = sc.nextInt();
			}
		}

		System.out.println("second array");
		for(int i=0; i<2; i++) {
			for(int j=0; j<3; j++) {
				arr2[i][j] = sc.nextInt();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<2; i++) {
			for(int j=0; j<3; j++) {
				sb.append(arr1[i][j]*arr2[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

