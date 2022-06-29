package Beginner_Coder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 여러가지_3427_볼모으기_시간초과 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char[] arr = br.readLine().toCharArray();
		char[] arr_temp = new char[N];
		for(int i=0; i<N; i++) {
			arr_temp[i] = arr[i];
		}
		// RBBBRBRRR
		// RB R을 옮김, B를 옮김 
		// BR R을 옮김, B를 옮김 
		// 4가지 경우 
		
		int result = 0;
		int result_temp = 0;
		int temp;
		// RB
		// R을 옮김
		temp = 0;
		for(int i=0; i<N; i++) {
			if(arr_temp[i] == 'B') {
				temp++;
			} else {
				if(temp>0) {
					arr_temp[i-temp] = 'R';
					arr_temp[i] = 'B';
					i -= temp;
					temp = 0;
					result++;
//					System.out.println("1: " + Arrays.toString(arr_temp));
				}
			}
		}
				
		// B를 옮김 
		temp = 0;
		for(int i=0; i<N; i++) {
			arr_temp[i] = arr[i];
		}
		for(int i=N-1; i>=0; i--) {
			if(arr_temp[i] == 'R') {
				temp++;
			} else {
				if(temp>0) {
					arr_temp[i+temp] = 'B';
					arr_temp[i] = 'R';
					i += temp;
					temp = 0;
					result_temp++;
//					System.out.println("2: " + Arrays.toString(arr_temp));
				}
			}
			if(result_temp>=result) break;
		}
		if(result_temp < result) result = result_temp;
		
		// BR
		// R을 옮김
		temp = 0;
		result_temp = 0;
		for(int i=0; i<N; i++) {
			arr_temp[i] = arr[i];
		}
		for(int i=N-1; i>=0; i--) {
			if(arr_temp[i] == 'B') {
				temp++;
			} else {
				if(temp>0) {
					arr_temp[i+temp] = 'R';
					arr_temp[i] = 'B';
					i += temp;
					temp = 0;
					result_temp++;
//					System.out.println("3: " + Arrays.toString(arr_temp));
				}
			}
			if(result_temp>=result) break;
		}
		if(result_temp < result) result = result_temp;
		
		// B를 옮김 
		temp = 0;
		result_temp = 0;
		for(int i=0; i<N; i++) {
			arr_temp[i] = arr[i];
		}
		for(int i=0; i<N; i++) {
			if(arr_temp[i] == 'R') {
				temp++;
			} else {
				if(temp>0) {
					arr_temp[i-temp] = 'B';
					arr_temp[i] = 'R';
					i -= temp;
					temp = 0;
					result_temp++;
//					System.out.println("4: " + Arrays.toString(arr_temp));
				}
			}
			if(result_temp>=result) break;
		}
		if(result_temp < result) result = result_temp;

		System.out.println(result);
	}
}
