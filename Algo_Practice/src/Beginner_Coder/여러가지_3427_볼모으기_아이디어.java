package Beginner_Coder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 여러가지_3427_볼모으기_아이디어 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char[] arr = br.readLine().toCharArray();
		
		int Rcnt = 0;
		int Bcnt = 0;
		
		for(int i=0; i<N; i++) {
			if(arr[i] == 'R') Rcnt++;
			else Bcnt++;
		}
		
		// RBBBRBRRR
		// BBRBBBBR
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
			if(arr[i] == 'R') {
				temp++;
			} else {
				break;
			}
		}
		result = Rcnt-temp;	
		// B를 옮김 
		temp = 0;
		for(int i=N-1; i>=0; i--) {
			if(arr[i] == 'B') {
				temp++;
			} else {
				break;
			}
		}
		result_temp = Bcnt-temp;
		if(result_temp < result) result = result_temp;
		// BR
		// R을 옮김
		temp = 0;
		for(int i=N-1; i>=0; i--) {
			if(arr[i] == 'R') {
				temp++;
			} else {
				break;
			}
		}
		result_temp = Rcnt-temp;
		if(result_temp < result) result = result_temp;
		
		// B를 옮김 
		temp = 0;
		for(int i=0; i<N; i++) {
			if(arr[i] == 'B') {
				temp++;
			} else {
				break;
			}
		}
		result_temp = Bcnt-temp;
		if(result_temp < result) result = result_temp;

		System.out.println(result);
	}
}
