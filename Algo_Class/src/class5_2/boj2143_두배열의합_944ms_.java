package class5_2;

import java.util.*;
import java.io.*;

public class boj2143_두배열의합_944ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // -1000000000~1000000000
		int n = Integer.parseInt(br.readLine()); // 1~1000
		int[] A_sum = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			A_sum[i] = A_sum[i-1] + Integer.parseInt(st.nextToken()); // -1000000~1000000
		}
		
		int m = Integer.parseInt(br.readLine()); // 1~1000
		int[] B_sum = new int[m+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=m; i++) {
			B_sum[i] = B_sum[i-1] + Integer.parseInt(st.nextToken()); // -1000000~1000000
		}
		
		ArrayList<Integer> A_sub = new ArrayList<Integer>();
		ArrayList<Integer> B_sub = new ArrayList<Integer>();

		for(int i=1; i<=n; i++) {
			A_sub.add(A_sum[i]);
			for(int j=i+1; j<=n; j++) {
				//  i부터 j까지의 부분합 구하기 
				A_sub.add(A_sum[j]-A_sum[i]);
			}
		}
		
		for(int i=1; i<=m; i++) {
			B_sub.add(B_sum[i]);
			for(int j=i+1; j<=m; j++) {
				//  i부터 j까지의 부분합 구하기 
				B_sub.add(B_sum[j]-B_sum[i]);
			}
		}
		
		Collections.sort(A_sub);
		Collections.sort(B_sub);
			
		// 부분합의 합. 쌍의 개수 
		int size_a = A_sub.size();
		int size_b = B_sub.size();
		int pa = 0;
		int pb = size_b-1;
		long result = 0;
		
		while(pa<size_a && pb>=0) {
			int temp_sum = A_sub.get(pa) + B_sub.get(pb);
			if(temp_sum < T) {
				// 작으면 pa++
				pa++;
			} else if(temp_sum > T) {
				// 크면 pb--;
				pb--;
			} else {
				// 같으면 : 현재 수보다 클때까지 개수 세기 
				int cur_a = A_sub.get(pa);
				int cur_b = B_sub.get(pb);
				long cnt_a = 0;
				long cnt_b = 0;
				
				while(A_sub.get(pa) == cur_a) {
					cnt_a++;
					pa++;
					if(pa == size_a) break;
				}
				while(B_sub.get(pb) == cur_b) {
					cnt_b++;
					pb--;
					if(pb == -1) break;
				}
				
				result += cnt_a*cnt_b;
			}
		}
		
		System.out.println(result);
	}
}
