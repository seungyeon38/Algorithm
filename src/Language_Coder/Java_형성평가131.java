package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_형성평가131 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder(); 
		
		if(n1 > n2) {
			for(int i=n2; i<=n1; i++) {
				sb.append(i).append(" ");
			}
		} else {
			for(int i=n1; i<=n2; i++) {
				sb.append(i).append(" ");
			}			
		}
		
		System.out.println(sb.toString());
	}
}