package class5_2;

import java.util.*;
import java.io.*;

public class boj2143_두배열의합_1004ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // -1000000000~1000000000
		
		int n = Integer.parseInt(br.readLine()); // 1~1000
		int[] A_dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		A_dp[0] = Integer.parseInt(st.nextToken());
		for(int i=1; i<n; i++) {
			A_dp[i] = A_dp[i-1]+Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine()); // 1~1000
		int[] B_dp = new int[m];
		st = new StringTokenizer(br.readLine());
		B_dp[0] = Integer.parseInt(st.nextToken());
		for(int i=1; i<m; i++) {
			B_dp[i] = B_dp[i-1]+ Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> A_sublist = new ArrayList<Integer>();
		ArrayList<Integer> B_sublist = new ArrayList<Integer>();

		for(int i=0; i<n; i++) { // 시작점 
			A_sublist.add(A_dp[i]);
			for(int j=i+1; j<n; j++) { // 끝점 
				A_sublist.add(A_dp[j]-A_dp[i]);
			}
		}
		
		for(int i=0; i<m; i++) { // 시작점 
			B_sublist.add(B_dp[i]);
			for(int j=i+1; j<m; j++) { // 끝점 
				B_sublist.add(B_dp[j]-B_dp[i]);
			}
		}
		
		Collections.sort(A_sublist);
		Collections.sort(B_sublist);

		int A_size = A_sublist.size();
		int B_size = B_sublist.size();
		int A_p = 0;
		int B_p = B_size-1; 
		long result = 0;
		
		while(A_p<A_size && B_p>=0) {
			int A_sum = A_sublist.get(A_p);
			int B_sum = B_sublist.get(B_p);
			int sum = A_sum + B_sum;
			
			if(sum == T) {
				long A_cnt = 0; 
				long B_cnt = 0; 
				
				while(A_p<A_size && A_sublist.get(A_p)==A_sum) {
					A_cnt++;
					A_p++;
				}
				while(B_p>=0 && B_sublist.get(B_p)==B_sum) {
					B_cnt++;
					B_p--;
				}
				
				result += A_cnt*B_cnt;
			} else if(sum < T) {
				A_p++;
			} else {
				B_p--;
			}
		}
		
		System.out.println(result);
	}
}
