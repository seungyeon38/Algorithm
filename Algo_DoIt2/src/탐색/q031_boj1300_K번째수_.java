package 탐색;

import java.util.*;
import java.io.*;

public class q031_boj1300_K번째수_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // ~10^5  
		long k = Integer.parseInt(br.readLine()); // 10^9 보다 작은 수 
		
		// k번째 수 
		// B[k] = x 
		// x보다 작은 수가 k개 
		
		// x : 1~10^9
		// k를 구해보면 됨 
		long s = 1;
		long e = k;
		while(s <= e) {
			long mid = (s+e)/2; 
			long result = getK(N, mid);
			
			System.out.println("(s, e, result): " + s + ", " + e + ", " + result);

			if(result < k) {
				s = mid+1; 
			} else if(result > k) {
				e = mid-1; 
			} else {
				System.out.println(result);
				break;
			}
		}
	}
	
	public static long getK(int N, long x) { // x보다 작은 수 출력 
		long result = 0; 
		for(long i=1; i<=x; i++) { // 1단부터 x단까지 
			result += Math.min(x/i, N);
		}
		
		return result; 
	}
}
