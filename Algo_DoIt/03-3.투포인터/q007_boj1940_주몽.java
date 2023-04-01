package Algorithm;

import java.io.*;
import java.util.*;

public class q007_boj1940 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 15000
		int M = Integer.parseInt(br.readLine()); // 10000000
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] num_arr = new int[N];
		
		for(int i=0; i<N; i++) {
			num_arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬 
		Arrays.sort(num_arr);
		
		int sp = 0;
		int fp = N-1;
		int result = 0;
		
		while(sp < fp) {
			if(num_arr[sp]+num_arr[fp] < M) {
				sp++;
			} else if(num_arr[sp]+num_arr[fp] > M) {
				fp--;
			} else if(num_arr[sp]+num_arr[fp] == M) {
				result++;
				sp++;
				fp--;
			}
		}
		
		System.out.println(result);
	}
}
