package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_형성평가147 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
//		1 2 3	0 3
//		  4 5	2 2
//		    6	4 1
		int num = 1;
		
		for(int i=0; i<n; i++) {
			for(int j=0, size=2*i; j<size; j++) {
				sb.append(" ");
			}
			for(int j=i; j<n; j++) {
				sb.append(num++).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

