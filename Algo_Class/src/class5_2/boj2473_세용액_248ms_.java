package class5_2;

import java.util.*;
import java.io.*;

public class boj2473_세용액_248ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 전체 용액의 수 3~5000
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] water = new long[N]; // 용액의 특성값 -1000000000~1000000000
		
		for(int i=0; i<N; i++) {
			water[i] = Long.parseLong(st.nextToken());
		}
		
		// 특성값이 0에 가장 가까운 용액을 만들어내는 세 용액의 특성값 구하기 
		Arrays.sort(water);
		
		long result = 3000000001L;
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		boolean done = false; 
		
		for(int i=0; i<N-2; i++) { // 고정 용액 
			int left = i+1; 
			int right = N-1;
			
			while(left < right) {
				long temp = water[i]+water[left]+water[right];
				
				if(result > Math.abs(temp)) {
					result = Math.abs(temp);
					n1 = i; 
					n2 = left; 
					n3 = right; 
				}

				if(temp < 0) { 
					left++;
				} else if(temp > 0) {
					right--;
				} else {
					done = true; 
					break; 
				}
			}
					
			if(done) break; 
		}
		
		System.out.println(water[n1] + " " + water[n2] + " " + water[n3]);
	}
}
