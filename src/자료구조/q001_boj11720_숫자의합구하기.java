package 자료구조;

import java.util.*;
import java.io.*;

public class q001_boj11720_숫자의합구하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~100
		char[] nums = br.readLine().toCharArray(); 
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += nums[i]-'0';
		}
		
		System.out.println(sum);
	}
}
