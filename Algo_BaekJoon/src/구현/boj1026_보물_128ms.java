package 구현;

import java.util.*;
import java.io.*;

public class boj1026_보물_128ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 수 개수 1~50 
		
		int[] A = new int[N];
		int[] B = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken()); // 0~100
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		// A는 재배열, B는 재배열X 
		// B 숫자의 우선순위에 맞게 A 배열해야 함.
		// 결국 B도 배열해도 된다. 
		Arrays.sort(A);
		Arrays.sort(B);
		int result = 0;
		for(int i=0; i<N; i++) {
			result += A[i]*B[N-i-1];
		}
		
		System.out.println(result);
	}
}
