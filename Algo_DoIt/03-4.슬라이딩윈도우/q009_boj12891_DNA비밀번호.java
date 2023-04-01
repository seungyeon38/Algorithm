package Algorithm;

import java.io.*;
import java.util.*;

public class q009_boj12891 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken()); // 문자열 길이 (1000000)
		int P = Integer.parseInt(st.nextToken()); // 부분문자열 길이 (1000000)
		
		char[] arr = br.readLine().toCharArray();
		
		int[] num_arr = new int[4]; // {‘A’, ‘C’, ‘G’, ‘T’}
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<4; i++) {
			num_arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] cur_num = new int[4];
		int result = 0;
		
		for(int n=0; n<P; n++) {
			char c = arr[n];
			
			if(c == 'A') {
				cur_num[0]++;
			} else if(c == 'C') {
				cur_num[1]++;
			} else if(c == 'G') {
				cur_num[2]++;
			} else if(c == 'T') {
				cur_num[3]++;
			}
		}
		
		if(isPossible(num_arr, cur_num)) {
			result++;
		}
		
		int sp = 0;
		int fp = S-P;

		while(sp <= fp) {
			char bc = arr[sp];
			
			if(++sp <= fp) {
				if(bc == 'A') {
					cur_num[0]--;
				} else if(bc == 'C') {
					cur_num[1]--;
				} else if(bc == 'G') {
					cur_num[2]--;
				} else if(bc == 'T') {
					cur_num[3]--;
				}
				
				char fc = arr[sp+P-1];
				
				if(fc == 'A') {
					cur_num[0]++;
				} else if(fc == 'C') {
					cur_num[1]++;
				} else if(fc == 'G') {
					cur_num[2]++;
				} else if(fc == 'T') {
					cur_num[3]++;
				}
				
				if(isPossible(num_arr, cur_num)) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
	
	public static boolean isPossible(int[] num_arr, int[] cur_num){
		boolean result = true;
		
		for(int i=0; i<4; i++) {
			if(num_arr[i] > cur_num[i]) {
				result = false; 
				break;
			}
		}
		
		return result;
	}
}
