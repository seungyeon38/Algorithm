package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_형성평가137 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=r; i++) {
			for(int j=1; j<=c; j++) {
				sb.append(i*j).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}