package Beginner_Coder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 자료처리_1814_삽입정렬횟후세기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int move_idx; // 옮겨질 자리 
		int cur_n; // 옮길 숫자 
		int result = 0;
		for(int i=0; i<N; i++) {
			cur_n = arr[i];
			move_idx = i;
			// 자기 앞 수부터 인덱스 0까지 자기보다 작은 수 찾기 
			for(int j=i-1; j>=0; j--) {
				if(cur_n<arr[j]) move_idx = j;
				else break;
			}
			// 이동 
			for(int j=i-1; j>=move_idx; j--) {
				arr[j+1] = arr[j];
				result++;
			}
			arr[move_idx] = cur_n;
		}
		
		System.out.println(result);
	}
}
