package Algorithm;

import java.util.*;
import java.io.*;

public class boj2798_블랙잭 {
	static int result = 0;
	static int N, M;
	static int[] cards;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 100
		M = Integer.parseInt(st.nextToken()); // 300000
		
		cards = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		recur(0, 0, -1);
		
		System.out.println(result);
	}
	
	public static void recur(int sum, int idx, int b_idx) {
		if(sum > M) return;
		
		if(idx == 3) {
			if(sum<=M && result<sum) {
				result = sum;
			}
			return;
		}
		
		for(int i=b_idx+1; i<N; i++) {
			recur(sum+cards[i], idx+1, i);
		}
	}
}
