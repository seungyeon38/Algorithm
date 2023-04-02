package 자료구조;

import java.util.*;
import java.io.*;

public class q009_boj12891_DNA비밀번호 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken()); // 문자열 길이 1~1000000
		int P = Integer.parseInt(st.nextToken()); // 부분문자열 길이 1~1000000
		char[] str = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		int[] cnt = new int[4];
		for(int i=0; i<4; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] temp = new int[4]; 
		int result = 0; 
		
		for(int i=0; i<P; i++) {
			if(str[i] == 'A') {
				temp[0]++;
			} else if(str[i] == 'C') {
				temp[1]++;
			} else if(str[i] == 'G') {
				temp[2]++;
			} else if(str[i] == 'T') {
				temp[3]++;
			}
		}
		
		boolean isPossible = true; 
		for(int i=0; i<4; i++) {
			if(temp[i] < cnt[i]) isPossible = false; 
		}
		if(isPossible) result++;
		
		for(int i=1, max=S-P+1; i<max; i++) {
			char b_c = str[i-1]; 
			
			if(b_c == 'A') {
				temp[0]--;
			} else if(b_c == 'C') {
				temp[1]--;
			} else if(b_c == 'G') {
				temp[2]--;
			} else if(b_c == 'T') {
				temp[3]--;
			}
			
			char n_c = str[i+P-1];
			
			if(n_c == 'A') {
				temp[0]++;
			} else if(n_c == 'C') {
				temp[1]++;
			} else if(n_c == 'G') {
				temp[2]++;
			} else if(n_c == 'T') {
				temp[3]++;
			}
			
			isPossible = true; 
			for(int j=0; j<4; j++) {
				if(temp[j] < cnt[j]) isPossible = false; 
			}
			if(isPossible) result++;
		}
		
		System.out.println(result);
	}
}
