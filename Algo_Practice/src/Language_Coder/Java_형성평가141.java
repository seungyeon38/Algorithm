package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_형성평가141 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int temp = n;
		
		StringBuilder sb = new StringBuilder();
		while(temp%10 != 0 && temp<100) {
			sb.append(temp).append(" ");
			temp += n;
		}
		
		if(temp<100) sb.append(temp);
		System.out.println(sb.toString());	
	}
}