package 자료구조;

import java.util.*;
import java.io.*;

public class boj2018_수들의합5_180ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~10000000
		int result = 1; // 자기 자신 포함 
		int sp = 1; 
		int ep = 1;
		int temp_sum = 1;
		while(ep < N) {
			if(temp_sum < N) {
				ep++;
				temp_sum += ep;
			} else if(temp_sum > N) {
				temp_sum -= sp;
				sp++;
			} else {
				result++;
				temp_sum -= sp;
				sp++;
				ep++;
				temp_sum += ep;
			}
		}
		
		System.out.println(result);
	}
}
