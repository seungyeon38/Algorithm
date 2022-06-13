package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_형성평가125 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=n; i++) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}