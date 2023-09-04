package 정렬;

import java.util.*;
import java.io.*;

public class boj11399_ATM_148ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 사람의 수 1~1000
		int[] P = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			P[i] = Integer.parseInt(st.nextToken()); // 1~1000
		}
		
		// 오름차순 정렬 
		for(int i=1; i<N; i++) { // 정렬할 수 
			int num = P[i];
			int idx = i;
			for(int j=0; j<i; j++) { // 정렬 위치 
				if(P[j] >= num) {
					idx = j;
					break;
				}
			}
			
			for(int j=i; j>idx; j--) {
				// 뒤로 한칸씩
				P[j] = P[j-1];
			}
			
			P[idx] = num;
		}
		
		int temp_sum = 0;
		int result = 0;
		for(int i=0; i<N; i++) {
			temp_sum += P[i];
			result += temp_sum;
		}
		
		System.out.println(result);
	}
}
