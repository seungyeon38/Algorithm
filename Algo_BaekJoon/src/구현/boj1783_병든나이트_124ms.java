package 구현;

import java.util.*;
import java.io.*;

public class boj1783_병든나이트_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 세로 길이 1~2000000000
		int M = Integer.parseInt(st.nextToken()); // 가로 길이 1~2000000000
		
		int answer = 0;
		if(N == 1) answer = 1;
		else if(N == 2) answer = Math.min(4, (M-1)/2+1);
		else if(N >= 3) {
			if(M >= 7) answer = M-2;
			else answer = Math.min(4, M);
		}
		
		System.out.println(answer);
	}
}
