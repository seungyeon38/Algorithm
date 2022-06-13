package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_형성평가145 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();

//	      1		4 1 1 
//	    1 2		2 2 2
//	  1 2 3		0 3 3
		int num;
		for(int i=1; i<=n; i++) {
			num = 1;
			for(int j=0, size=2*(n-i); j<size; j++) {
				sb.append(" ");
			}
			for(int j=0; j<i; j++) {
				sb.append(num++).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

