package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_형성평가138 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				sb.append("(").append(i).append(", ").append(j).append(")").append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}