package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_형성평가168 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			arr[i][0] = 1;
			for(int j=1; j<=i; j++) {
				arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=n-1; i>=0; i--) {
			int j=0; 
			while(j<n && arr[i][j] != 0) {
				sb.append(arr[i][j++]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

