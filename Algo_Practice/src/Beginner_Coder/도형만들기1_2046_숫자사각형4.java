package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도형만들기1_2046_숫자사각형4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken()); // 길이 
		int m = Integer.parseInt(st.nextToken()); // 종류 
		
		if(m == 1) {
			print1(n);
		} else if(m == 2) {
			print2(n);
		} else if(m == 3) {
			print3(n);
		}
	}
	
	public static void print1(int n) {
		int num = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(num + " ");
			}
			num++;
			System.out.println();
		}
	}
	
	public static void print2(int n) {
		int num;
		for(int i=0; i<n; i++) {
			if(i%2 == 0) {
				num = 1;
				for(int j=0; j<n; j++) {
					System.out.print(num++ + " ");
				}				
			} else {
				num = n;
				for(int j=0; j<n; j++) {
					System.out.print(num-- + " ");
				}		
			}
			System.out.println();
		}
	}
	
	public static void print3(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(i*j + " ");
			}
			System.out.println();
		}
	}
}
