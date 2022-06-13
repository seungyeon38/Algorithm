package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_자가진단554 {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int n_c = 1;
		int c_c = 'A';
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=n-i; j++) {
				sb.append(n_c++).append(" ");
			}
			for(int j=0; j<i; j++) {
				sb.append((char)c_c++).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}