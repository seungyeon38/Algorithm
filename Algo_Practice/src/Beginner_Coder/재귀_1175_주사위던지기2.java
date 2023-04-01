package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 재귀_1175_주사위던지기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 주사위를 던진 횟수 (2≤N≤8)
		int M = Integer.parseInt(st.nextToken()); // 눈의 합 (1≤M≤40)
		
		calc(0, N, new int[N], M, 0);
	}
	
	public static void calc(int idx, int n, int[] arr, int sum, int temp) {
		// 현재 합이 목표 합보다 크면 안됨 
		if(temp > sum) {
			return;
		}
			
		// 현재 횟수가 목표 횟수와 같음 
		if(idx == n) {
			if(temp < sum) return; // 합이 목표합보다 작으면 안됨 
			else if(temp == sum) { // 현재 합이 목표합이 같으면 답 
				for(int i=0; i<n; i++) {
					System.out.print(arr[i]+ " ");
				}
				System.out.println();
				return; 
			}
		}
		
		for(int i=1; i<=6; i++) {
			temp += i;
			arr[idx] = i;
			calc(idx+1, n, arr, sum, temp);
			temp -= i;
		}
	}
}
