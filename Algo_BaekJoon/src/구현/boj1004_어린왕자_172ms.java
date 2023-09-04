package 구현;

import java.util.*;
import java.io.*;

public class boj1004_어린왕자_172ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(); 
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()); // 출발점 -1000~1000
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken()); // 도착점 
			int y2 = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(br.readLine()); // 행성계의 개수 1~50
			int[][] planets = new int[n][3];
			int cnt = 0;
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				
				planets[i][0] = Integer.parseInt(st.nextToken()); // 중점 
				planets[i][1] = Integer.parseInt(st.nextToken());
				planets[i][2] = Integer.parseInt(st.nextToken()); // 반지름 
				// 두개 다 안에 있으면 X 
				// 한개만 안에 있으면 세기 
				int temp = 0;
				if(calc(x1, y1, planets[i][0], planets[i][1], planets[i][2])) temp++;
				if(calc(x2, y2, planets[i][0], planets[i][1], planets[i][2])) temp++;
				
				if(temp == 1) cnt++;
			}
			
			sb.append(cnt).append("\n");
		}
	
		// 출발점, 도착점이 몇 개의 원 안에 있는지 
		System.out.println(sb.toString());
	}
	
	// 두 점 사이의 거리가 반지름보다 작으면 안에 있는 것
	public static boolean calc(int x1, int y1, int x2, int y2, int r) {
		boolean result = false; 
		
		int dist = (int)(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
		if(dist < Math.pow(r, 2)) result = true; 
		
		return result; 
	}
}
