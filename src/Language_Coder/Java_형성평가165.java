package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_형성평가165 {
	public static void main(String[] args) throws IOException {	
		int[][] arr = new int[5][5];
		
		arr[0][0] = 1;
		arr[0][2] = 1;
		arr[0][4] = 1;
		
		for(int i=1; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(j>=1) {
					arr[i][j] += arr[i-1][j-1];
				}
				if(j>=-1 && j<4) {
					arr[i][j] += arr[i-1][j+1];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

