package 자료구조;

import java.util.*;
import java.io.*;

public class boj1546_평균_132ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 시험 본 과목의 개수 1~1000
		int sum = 0;
		int max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int score = Integer.parseInt(st.nextToken()); // 0~100
			sum += score;
			max = Math.max(max, score);
		}
		
		double result = (double)sum/max*100;
		System.out.println(result/N);
	}
}
