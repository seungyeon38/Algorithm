package 정수론;

import java.util.*;
import java.io.*;

public class boj1934_최소공배수_144ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			int origin_A = A;
			int origin_B = B;
			while(true) {
				int mod = 0;
				
				if(A < B) {
					mod = B%A;
					int temp = A;
					A = B%A;
					B = temp;
				} else {
					mod = A%B;
					int temp = B;
					B = A%B;
					A = temp;
				}

				if(mod == 0) break; 
			}
			
			sb.append(A<B ? origin_A*origin_B/B : origin_A*origin_B/A).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
