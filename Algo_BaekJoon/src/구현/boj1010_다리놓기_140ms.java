package 구현;

import java.util.*;
import java.io.*;

public class boj1010_다리놓기_140ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); 
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken()); // 서쪽 사이트 개수 0~30
			int e = Integer.parseInt(st.nextToken()); // 동쪽 사이트 개수 0~30
			
			int max = w<e ? e : w;
			int min = w<e ? w : e;
			
			int result = 1;
			for(int i=max, cnt=1; cnt<=min; cnt++, i--) {
				result *= i;
				result /= cnt;
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
