package Beginner_Coder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 자료처리_1158_삽입정렬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		int temp_idx; // 바꿔야되는 인덱스 
		int temp;
		for(int i=1; i<N; i++) {
			temp_idx = i;
			// 자기보다 앞 인덱스 중 자기보다 작은 수를 만날 때까지 (자기가 들어가야 할 인덱스 찾기)
			for(int j=i-1; j>=0; j--) {
				if(arr[j]>arr[i]) {
					temp_idx = j;
				} else {
					break;
				}
			}
			// 자기보다 앞 인덱~자기가 들어가야 할 자리에 있는 숫자 하나씩 뒤로 
			temp = arr[i];
			for(int j=i-1; j>=temp_idx; j--) {
				arr[j+1] = arr[j];
			}
			arr[temp_idx] = temp; // 자기 수 넣기 
			// 프린트
			for(int idx=0; idx<N; idx++) {
				sb.append(arr[idx]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
