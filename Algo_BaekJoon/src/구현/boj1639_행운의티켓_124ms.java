package 구현;

import java.util.*;
import java.io.*;

public class boj1639_행운의티켓_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 연속된 부분 문자열 중 행운 티켓 규칙을 만족하는 최대 부분 문자열 길이 구하기 
		String S = br.readLine();
		int length = S.length();
		int result = length/2*2; // 문자열 길이 

		while(result > 0) {
			boolean done = false; 
			for(int i=0, max=length-result; i<=max; i++) { // 시작점 
				int left_sum = 0;
				int right_sum = 0;
				for(int j=i, mid=result/2+i; j<mid; j++) {
					left_sum += S.charAt(j)-'0';
				}
				for(int j=result/2+i, m=result+i; j<m; j++) {
					right_sum += S.charAt(j)-'0';
				}
				
				if(left_sum == right_sum) {
					done = true;
					break;
				}
			}
			
			if(done) break;
			result -= 2;
		}
		
		System.out.println(result);
	}
}
