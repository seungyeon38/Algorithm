package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_형성평가146 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
//		A B C	3 0
//		D E 0	2 1
//		F 1 2	1 2
		
		int c = 'A';
		int num = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0, size=n-i; j<size; j++) {
				sb.append((char)c++).append(" ");
			}
			for(int j=0; j<i; j++) {
				sb.append(num++).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

