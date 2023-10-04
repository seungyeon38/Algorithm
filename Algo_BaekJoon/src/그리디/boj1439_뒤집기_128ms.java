package 그리디;

import java.util.*;
import java.io.*;

public class boj1439_뒤집기_128ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 최소로 뒤집기 
		String S = br.readLine(); // 0~1000000 길이 
		
		int cnt_0 = 0;
		int cnt_1 = 0;

		for(int i=0, length=S.length(); i<length; i++) {
			if(S.charAt(i) == '0') {
				cnt_0++;
				while(i<length && S.charAt(i)=='0') {
					i++;
				}
				i--;
			} else {
				cnt_1++;
				while(i<length && S.charAt(i)=='1') {
					i++;
				}
				i--;
			}
		}
		
		System.out.println(cnt_0>cnt_1 ? cnt_1 : cnt_0);
	}
}
