package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도형만들기1_1303_숫자사각형1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken()); // 높이 
		int m = Integer.parseInt(st.nextToken()); // 너비 
		
		int num = 1;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				sb.append(num++).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
