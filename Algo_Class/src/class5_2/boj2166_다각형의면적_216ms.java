package class5_2;

import java.util.*;
import java.io.*;

public class boj2166_다각형의면적_216ms {
	static int N;
	static long[][] points;
	static double result; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 다각형을 이루는 점 개수 3~10000
		points = new long[N+1][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}
		
		points[N][0] = points[0][0];
		points[N][1] = points[0][1];
		
		calc(0);
		System.out.println(String.format("%.1f", Math.abs(result/2)));
	}
	
	public static void calc(int idx) {
		if(idx == N) {
			return; 
		}
		
		result += points[idx][0]*points[idx+1][1];
		result -= points[idx+1][0]*points[idx][1];
		calc(idx+1);
	}
}
