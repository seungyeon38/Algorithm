package 자료구조;

import java.util.*;
import java.io.*;

public class q006_boj2018_수들의합5 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~10000000
		
		int[] num = new int[N+1];
		for(int i=1; i<=N; i++) {
			num[i] = i;
		}
		
		int sp = 0;
		int ep = 0;
		int temp_n = 0;
		int cnt = 0; 
		
		while(ep <= N) {
			if(temp_n == N) {
				cnt++;
				temp_n -= sp;
				sp++;
				ep++;
				temp_n += ep;
			} else if(temp_n < N) {
				ep++; 
				temp_n += ep; 
			} else {
				temp_n -= sp;
				sp++;
			}
		}
		
		System.out.println(cnt);
	}
}
