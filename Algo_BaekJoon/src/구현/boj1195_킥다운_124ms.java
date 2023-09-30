package 구현;

import java.util.*;
import java.io.*;

public class boj1195_킥다운_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 맞물리게 하였을 때 가로 너비가 짧을수록 효율적인 킥다운 장치
		// 두 기어가 주어졌을 때 맞물리게 하는 가장 짧은 가로 너비 구하기 
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int str1_length = str1.length();
		int str2_length = str2.length();
		
		int[] gear1 = new int[str1_length]; // 1~100
		int[] gear2 = new int[str2_length];
		
		for(int i=0; i<str1_length; i++) {
			gear1[i] = str1.charAt(i)-'0';
		}
		
		for(int i=0; i<str2_length; i++) {
			gear2[i] = str2.charAt(i)-'0';
		}
		
		int idx1 = 0;
		int idx2 = 0;
		
		int result = 0;
		
		// 첫번째 기어 우선 (첫번째 기어에 두번째 기어 맞추기) 
		while(idx1<str1_length) {
			idx2 = 0;
			if(gear1[idx1]+gear2[idx2] <= 3) { // 맞물리는 경우
				int temp_idx1 = idx1; // 시작 부분 
				// 튀어나온 연속된 부분이 다 들어가는지 확인 
				boolean possible = true;
				while(temp_idx1<str1_length && idx2<str2_length) {
					if(gear1[temp_idx1]+gear2[idx2]>3) {
						possible = false; 
						break;
					}
					temp_idx1++;
					idx2++;
				}
				
				if(possible) {
					result = str1_length;
					// 두번째 기어 길이가 남는 경우
					if(idx2 < str2_length) {
						result += str2_length-idx2;
					}
					break;
				}
			}
			
			idx1++;
		}

		idx2 = 0;
		
		// 두번째 기어 우선 (두번째 기어에 첫번째 기어 맞추기)  
		while(idx2<str2_length) {
			idx1 = 0;
			if(gear1[idx1]+gear2[idx2] <= 3) { // 맞물리는 경우
				int temp_idx2 = idx2; // 시작 부분 
				// 튀어나온 연속된 부분이 다 들어가는지 확인 
				boolean possible = true;
				while(idx1<str1_length && temp_idx2<str2_length) {
					if(gear1[idx1]+gear2[temp_idx2]>3) {
						possible = false; 
						break;
					}
					idx1++;
					temp_idx2++;
				}
				
				if(possible) {
					int temp_result = str2_length;
					// 첫번째 기어 길이가 남는 경우
					if(idx1 < str1_length) {
						temp_result += str1_length-idx1;
					}
					
					if(result != 0) result = Math.min(result, temp_result);
					else result = temp_result;
					
					break;
				}
			}
			
			idx2++;
		}
		
		System.out.println(result==0 ? str1_length+str2_length : result);
	}
}
