package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_자가진단553 {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int c = 0;
		for(int i=n; i>0; i--) {
			for(int j=0; j<i; j++) {
				sb.append((char)('A'+ c++));
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}