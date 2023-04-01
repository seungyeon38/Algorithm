package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학2_1534_10진수를2816진수로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		switch(B) {
		case 2:
			n_2(N);
			break;
		case 8:
			n_8(N);
			break;
		case 16:
			n_16(N);
			break;
		}
	}
	
	public static void n_2(int n) {
		StringBuilder sb = new StringBuilder();
		
		while(n != 0) {
			sb.append(n%2);
			n /= 2;
		}
		
		System.out.println(sb.reverse().toString());
	}
	
	public static void n_8(int n) {
		StringBuilder sb = new StringBuilder();

		while(n != 0) {
			sb.append(n%8);
			n /= 8;
		}
		
		System.out.println(sb.reverse().toString());
	}
	
	public static void n_16(int n) {
		StringBuilder sb = new StringBuilder();		

		while(n != 0) {
			int m = n%16;
			if(m<10) {
				sb.append(m);
			} else {
				sb.append((char)('A'+m-10));
			}
			n /= 16;
		}
		
		System.out.println(sb.reverse().toString());
	}
}
