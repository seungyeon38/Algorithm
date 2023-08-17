package 구현;

import java.util.*;
import java.io.*;

public class boj1011_flymetothealphacentauri_124ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 최소한의 작동 횟수로 이동 
		// 마지막 이동거리는 1광년 
		
		int T = Integer.parseInt(br.readLine()); 
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 현재 위치 
			int y = Integer.parseInt(st.nextToken()); // 목표 위치 
			
			int distance = y-x;
			int max = (int)Math.sqrt(distance);
			
			if(max*max == distance) {
				sb.append(2*max-1).append("\n");
			} else if(distance <= max*max+max) {
				sb.append(2*max).append("\n");
			} else {
				sb.append(2*max+1).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
