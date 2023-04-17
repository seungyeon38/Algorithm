package day2;

import java.util.*;
import java.io.*;

public class boj13908_비밀번호_S2_ {
	static int n, m;
	static boolean[] needs; 
	static int result; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 비밀번호의 길이 1~7
		m = Integer.parseInt(st.nextToken()); // 비밀번호에 들어가는 수 0~n
		
		needs = new boolean[10];
		
		if(m != 0) st = new StringTokenizer(br.readLine()); 
		
		for(int i=0; i<m; i++) {
			needs[Integer.parseInt(st.nextToken())] = true;
		}

		calc(0, 0);
		System.out.println(result);
	}	
	
	public static void calc(int idx, int cnt) {
		if(idx == n) {
			if(cnt == m) result++; 
			return; 
		}
		
		for(int i=0; i<10; i++) {
			if(needs[i]) {
				needs[i] = false; 
				calc(idx+1, cnt+1);
				needs[i] = true; 
			} else {
				calc(idx+1, cnt);
			}
		}
	}
}
