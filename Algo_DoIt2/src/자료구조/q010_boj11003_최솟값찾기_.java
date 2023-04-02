package 자료구조;

import java.util.*;
import java.io.*;


public class q010_boj11003_최솟값찾기_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1~5000000
		int L = Integer.parseInt(st.nextToken()); // 1~5000000
		
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] D = new int[N];
		int min = 5000001;
		for(int i=0; i<L; i++) {
			min = Math.min(min, nums[i]);
			D[i] = min;
		}
		
		for(int i=L; i<N; i++) {
			 
		}
	}
}
