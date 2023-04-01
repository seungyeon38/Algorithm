package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_형성평가143_별찍기 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int temp; 
		for(int i=0, size = 2*n-1; i<size; i++) {
			temp = i < n ? i : size-i-1;
			
			for(int j=0; j<temp; j++) {
				sb.append(" ");
			}
			for(int j=0, size2=size-2*temp; j<size2; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

