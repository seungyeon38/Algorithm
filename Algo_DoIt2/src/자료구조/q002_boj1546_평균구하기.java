package 자료구조;

import java.util.*;
import java.io.*;

public class q002_boj1546_평균구하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1000
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double[] scores = new double[N];
		double max = 0; 
		for(int i=0; i<N; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, scores[i]);
		}
		
		for(int i=0; i<N; i++) {
			double score = scores[i];
			scores[i] = score/max*100;
		}
		
		double result = 0;
		for(int i=0; i<N; i++) {
			result += scores[i];
		}
		
		System.out.println(result/N);
	}
}
