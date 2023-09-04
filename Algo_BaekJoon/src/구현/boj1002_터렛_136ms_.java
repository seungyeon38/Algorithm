package 구현;

import java.io.*;
import java.util.*;

public class boj1002_터렛_136ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken()); // 조규현 좌표 -10000~10000
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken()); // 1~10000
			int x2 = Integer.parseInt(st.nextToken()); // 류재명 좌표 
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			// 중점 사이의 거리보다 클 때, 안에 있을 때(0) | 외접, 내접(1) | 두 점에서 만날 때(2) | 같을 때 (-1)
			int dist = (int)(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
			
			if(x1==x2 && y1==y2 && r1==r2) { // 같을 때 -1  
				sb.append("-1\n");
			} else if(dist>Math.pow(r1+r2, 2) || dist<Math.pow(r2-r1, 2)) { // 클 때, 안에 있을 때 0
				sb.append("0\n");
			} else if(dist==Math.pow(r1+r2, 2) || dist==Math.pow(r2-r1, 2)){ // 외접, 내접 1
				sb.append("1\n");
			} else {
				sb.append("2\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
