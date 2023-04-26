package day10;

import java.util.*;
import java.io.*; 

public class boj5875_오타_G3_164ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str = br.readLine().toCharArray();
		int[] sum = new int[str.length];
		int minus_idx = -1; // 가장 처음으로 -가 되는 것의 인덱스 
		int small_than_1_idx = 0; // 가장 뒤에 있는 것 중에 1보다 작거나 같은 것의 인덱스 
		int result = 0; 
		
		if(str[0] == '(') sum[0] = 1; 
		else {
			sum[0] = -1;
			minus_idx = 0;
		}
		
		for(int i=1; i<str.length; i++) {
			int temp = 0;
			if(str[i] == '(') temp = 1;
			else temp = -1; 
			
			sum[i] += sum[i-1] + temp;
			if(sum[i]<0 && minus_idx == -1) {
				minus_idx = i;
			}
			if(sum[i]<=1) {
				small_than_1_idx = i;
			}
		}
		
		if(sum[str.length-1] == -2) {
			// ')' -> '('
			for(int i=0; i<=minus_idx; i++) {
				if(str[i]==')') result++;
				if(i == minus_idx) break; 
			}
		} else if(sum[str.length-1] == 2) {
			// '(' -> ')'
			for(int i=small_than_1_idx+1; i<str.length; i++) {
				if(str[i]=='(' && sum[i]>=2) result++;
			}
			// 중간에 -나오면 안됨, 즉 i이후로 1인게 있으면 안됨 
		} else {
			// 안됨 
			result = 0;
		}
	
		System.out.println(result);
	}
}
