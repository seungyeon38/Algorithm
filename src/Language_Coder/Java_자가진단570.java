package Language_Coder;

import java.io.IOException;

public class Java_자가진단570 {
	public static void main(String[] args) throws NumberFormatException, IOException {	
//		1 1 1 1 1
//		1 2 3 4 5
//		1 3 6 10 15
//		1 4 10 20 35
//		1 5 15 35 70
		int[][] arr = new int[5][5];
		
		for(int i=0; i<5; i++) {
			arr[0][i] = 1;
			arr[i][0] = 1;
		}
		
		for(int i=1; i<5; i++) {
			for(int j=1; j<5; j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1];
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