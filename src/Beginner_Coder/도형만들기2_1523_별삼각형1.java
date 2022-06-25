package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도형만들기2_1523_별삼각형1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 높이 
		int M = Integer.parseInt(st.nextToken()); // 종류 
 		
		if(N<0 || N>100 || (M!=1 && M!=2 && M!=3)) {
			System.out.println("INPUT ERROR!");
		} else {
			switch(M) {
			case 1: 
				draw1(N);
				break;
			case 2:
				draw2(N);
				break;
			case 3:
				draw3(N);
				break;
			}			
		}
	}
	
	public static void draw1(int n){
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			for(int j=0; j<i; j++) {
				sb.append('*');				
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
	
	public static void draw2(int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=n; i>0; i--) {
			for(int j=0; j<i; j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
	
	public static void draw3(int n) {
		StringBuilder sb = new StringBuilder();
		// 5
		// 0	4 1
		// 1	3 3
		// 2	2 5
		// 3	1 7
		// 4	0 9
		
		for(int i=0; i<n; i++) {
			for(int j=0, size=n-1-i; j<size; j++) {
				sb.append(" ");
			}
			for(int j=0, size=i*2+1; j<size; j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
