package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도형만들기2_1641_숫자삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken()); // 높이 
		int m = Integer.parseInt(st.nextToken()); // 종류 
		
		if(n<0 || n>100 || n%2==0 || m<1 || m>3) {
			System.out.println("INPUT ERROR!");
		} else {
			switch(m) {
			case 1:
				print1(n);
				break;
			case 2:
				print2(n);
				break;
			case 3:
				print3(n);
				break;
			}			
		}
	}
	
	public static void print1(int n) {
		StringBuilder sb = new StringBuilder();
		// 1
		// 3 2
		// 4 5 6
		// 10 9 8 7
		// 11 12 13 14 15
		int num = 1;
		int temp;
		for(int i=1; i<=n; i++) {
			if(i%2 == 0) {
				num += i-1;
				temp = num+1;
				for(int j=0; j<i; j++) {
					sb.append(num--).append(' ');
				}
				num = temp;
			} else {
				for(int j=0; j<i; j++) {
					sb.append(num++).append(' ');
				}
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}

	public static void print2(int n) {
		StringBuilder sb = new StringBuilder();
		// 5 9
		// 6 11
		// 0 0 0 0 0 0 0 0 0	0 9
		//   1 1 1 1 1 1 1		1 7
		//     2 2 2 2 2		2 5
		//       3 3 3 			3 3
		//         4			4 1
		int m = n*2-1;
		int b;
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++) {
				sb.append("  ");
			}
			for(int j=0, size=m-2*i; j<size; j++) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
	
	public static void print3(int n) {
		StringBuilder sb = new StringBuilder();
		// 1 		1 1
		// 1 2		2 2
		// 1 2 3	3 3
		// 1 2 		4 2
		// 1 		5 1
		int half = n/2+1;
		int num;
		int m;
		for(int i=1; i<=n; i++) {
			if(i<half) m = i;
			else m = n+1-i; // 
				
			num = 1;
			
			for(int j=0; j<m; j++) {
				sb.append(num++).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
