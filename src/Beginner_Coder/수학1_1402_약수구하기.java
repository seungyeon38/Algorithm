package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학1_1402_약수구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		
		int n = 0;
		for(int i=1; i<=N; i++) {
			if(N%i == 0) {
				arr[n++] = i;
			}
		}
		
		int result = 0;
		for(int i=0; i<K; i++) {
			if(arr[i] == 0) {
				result = 0;
				break;
			}
			result = arr[i];
		}		
		
		System.out.println(result);
	}
}
