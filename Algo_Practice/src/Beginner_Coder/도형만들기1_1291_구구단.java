package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도형만들기1_1291_구구단 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		while(s<2 || s>9 || e<2 || e>9) {
			System.out.println("INPUT ERROR!");
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
		}
		
		if(s < e) {
			for(int i=1; i<10; i++) {
				for(int j=s; j<=e; j++) {
					print(j, i);
					System.out.print("   ");
				}
				System.out.println();
			}
		} else {
			for(int i=1; i<10; i++) {
				for(int j=s; j>=e; j--) {
					print(j, i);
					System.out.print("   ");
				}
				System.out.println();
			}
		}
	}
	
	public static void print(int n1, int n2) {
		System.out.printf("%d * %d = %2d", n1, n2, n1*n2);
	}
}
