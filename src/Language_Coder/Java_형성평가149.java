package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_형성평가149 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
//		1 3 5
//		7 9 1
//		3 5 7
		int num = 1;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(num).append(" ");
				if(num != 9) num += 2;
				else num = 1;
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

