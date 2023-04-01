package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도형만들기1_1341_구구단2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		if(s < e) {
			for(int i=s; i<=e; i++) {
				for(int j=1; j<10; j++) {
					print(i, j);
					System.out.print("   ");
					if(j%3 == 0) System.out.println();
				}
				System.out.println();
			}
		} else {
			for(int i=s; i>=e; i--) {
				for(int j=1; j<10; j++) {
					print(i, j);
					System.out.print("   ");
					if(j%3 == 0) System.out.println();
				}
				System.out.println();
			}
		}
	}
	
	public static void print(int n1, int n2) {
		System.out.printf("%d * %d = %2d", n1, n2, n1*n2);
	}
}
