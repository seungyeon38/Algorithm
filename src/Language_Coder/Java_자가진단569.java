package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_자가진단569 {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		int[][] arr = new int[5][4];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result;
		StringBuilder sb = new StringBuilder();
		int n = 0;
		for(int i=0; i<5; i++) {
			result = 0;
			for(int j=0; j<4; j++) {
				result += arr[i][j];
			}
			
			if((result /= 4) < 80) {
				sb.append("fail").append("\n");
			} else {
				sb.append("pass").append("\n");
				n++;
			}
		}
		sb.append("Successful : ").append(n);
		
		System.out.println(sb.toString());
	}
}