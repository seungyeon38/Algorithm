package 자료구조;

import java.util.*;
import java.io.*;

public class boj2018_수들의합5_128ms_수학 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~10000000
		int result = 0; 
		// 연속된 자연수로 나타내는 가지수 
		for(int i=1; i<=N; i++) { // 가지 수 
			// 1~(i-1) 까지를 빼고 나누어지면 끝 
			// (i*(i-1))/2
			if(N-(i*(i-1))/2 < i) break;
			if((N-(i*(i-1))/2)%i == 0) result++;
		}
		
		System.out.println(result);
	}
}
