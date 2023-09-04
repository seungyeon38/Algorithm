package Algorithm;

import java.util.*;
import java.io.*;

public class q018_boj11399 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 1000
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int result = 0;
		
		for(int i=N; i>0; i--) {
			result += arr[N-i]*i;
		}
		
		System.out.println(result);
	}
}
