package 자료구조;

import java.util.*;
import java.io.*;

public class boj12891_DNA비밀번호_348ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이 1~1000000
		int P = Integer.parseInt(st.nextToken()); // 비밀번호로 사용할 부분문자열의 길이 1~S
		
		// ACGT
		// 특정 문자의 개수가 특정 개수 이상이어야 한다. 
		String str = br.readLine();
		int[] cnt = new int[4]; // 개수 
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] temp = new int[4];
		
		for(int i=0; i<P; i++) {
			switch(str.charAt(i)) {
			case 'A':
				temp[0]++;
				break;
			case 'C':
				temp[1]++;
				break;
			case 'G':
				temp[2]++;
				break;
			case 'T':
				temp[3]++;
				break;
			}
		}
		
		int ep = P-1;
		int result = 0;
		while(ep < S) {
			boolean isPossible = true;
			for(int i=0; i<4; i++) {
				if(cnt[i] > temp[i]) {
					isPossible = false; 
					break;
				}
			}
			
			if(isPossible) result++;
			ep++;
			
			if(ep == S) break;
			switch(str.charAt(ep)) {
			case 'A':
				temp[0]++;
				break;
			case 'C':
				temp[1]++;
				break;
			case 'G':
				temp[2]++;
				break;
			case 'T':
				temp[3]++;
				break;
			}
			
			switch(str.charAt(ep-P)) {
			case 'A':
				temp[0]--;
				break;
			case 'C':
				temp[1]--;
				break;
			case 'G':
				temp[2]--;
				break;
			case 'T':
				temp[3]--;
				break;
			}
		}
		
		System.out.println(result);
	}
}
