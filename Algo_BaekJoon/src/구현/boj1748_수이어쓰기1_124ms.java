package 구현;

import java.util.*;
import java.io.*;

public class boj1748_수이어쓰기1_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		// 9 90(99) 900(999) 9000 
		// 81
		int digit = getDigit(N);
		int idx = 1;
		int result = 0;
		while(idx < digit) {
			result += 9 * Math.pow(10, idx-1) * idx;
			idx++;
		}
		
		result += (N-Math.pow(10, digit-1)+1)*digit;
		
		System.out.println(result);
	}
	
	public static int getDigit(int n) {
		int result = 1;
		while(n >= 10) {
			n /= 10;
			result++;
		}
		
		return result;
	}
}
