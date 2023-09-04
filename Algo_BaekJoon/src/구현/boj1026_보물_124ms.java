package 구현;

import java.util.*;
import java.io.*;

public class boj1026_보물_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~50
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] B = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		int result = 0;
		for(int i=0; i<N; i++) {
			result += A[i]*B[N-i-1];
		}
		
		System.out.println(result);
	}
}
