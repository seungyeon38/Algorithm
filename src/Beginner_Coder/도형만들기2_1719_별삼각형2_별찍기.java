package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도형만들기2_1719_별삼각형2_별찍기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken()); // 삼각형 크기 
		int m = Integer.parseInt(st.nextToken()); // 종류 
		
		if(n%2 == 0 || n<0 || n>100 || m<1 || m>4) {
			System.out.println("INPUT ERROR!");
		} else {
			switch(m) {
			case 1:
				draw1(n);
				break;
			case 2:
				draw2(n);
				break;
			case 3:
				draw3(n);
				break;
			case 4: 
				draw4(n);
				break;
			}
		}
	}
	
	public static void draw1(int n) {
		StringBuilder sb = new StringBuilder();
		// *
		// **
		// ***
		// **
		// *
		int half = n/2+1;
		int m;
		for(int i=1; i<=n; i++) {
			if(i>half) m = 2*half-i;
			else m = i;
			
			for(int j=0; j<m; j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
	
	public static void draw2(int n) {
		StringBuilder sb = new StringBuilder();
		//   * 1	2 1
		//  ** 2 	1 2
		// *** 3	0 3
		//  ** 4	1 2
		//   * 5	2 1
		int half = n/2+1;
		int b;
		int m;
		for(int i=1; i<=n; i++) {
			if(i>half) m = 2*half-i;
			else m = i;
			b = half-m;
			for(int j=0; j<b; j++) {
				sb.append(' ');
			}
			for(int j=0; j<m; j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
	
	public static void draw3(int n) {
		StringBuilder sb = new StringBuilder();
		// *****	0 1		0 5 
		//  *** 	1 2		1 3
		//   *		2 3		2 1
		//  ***		3 4		1 3
		// *****	4 5		0 5
		int half = n/2;
		int b;
		int m;
		for(int i=0; i<n; i++) {
			if(i>half) b = 2*half-i;
			else b = i;
			
			for(int j=0; j<b; j++) {
				sb.append(' ');
			}
			for(int j=0, size=n-2*b; j<size; j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
	
	public static void draw4(int n) {		
		StringBuilder sb = new StringBuilder();
		// ***		0	0 3
		//  **		1	1 2
		//   *		2	2 1
		//   **		3	2 2
		//   ***	4	2 3
		
		// ****			0	0 4
		//  ***			1	1 3
		//   **			2	2 2
		//    *			3	3 1
		//    **		4	3 2
		//    ***		5	3 3
		//    ****		6	3 4
		int half = n/2;
		int b;
		int m;
		for(int i=0; i<n; i++) {
			if(i<half) b = i;
			else b = half;
			
			if(i<half) m = half+1-i;
			else m = i-(half-1);
			
			for(int j=0; j<b; j++) {
				sb.append(' ');
			}
			for(int j=0; j<m; j++) {
				sb.append('*');				
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
