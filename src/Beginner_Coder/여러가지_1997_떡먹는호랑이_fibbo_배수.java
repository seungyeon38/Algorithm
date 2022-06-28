package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 여러가지_1997_떡먹는호랑이_fibbo_배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int D = Integer.parseInt(st.nextToken()); // 넘어온 날 
		int K = Integer.parseInt(st.nextToken()); // 준 떡의 개수 

		// a b a+b a+2b 2a+3b 3a+5b 5a+8b
		// 1 2 3 4 5 6 7
		// 1 0 1 1 2 3 5 
		// 0 1 1 2 3 5 8
		int[] fibbo = new int[D];
		fibbo[0] = 0;
		fibbo[1] = 1; 
		for(int i=2; i<D; i++) {
			fibbo[i] = fibbo[i-1] + fibbo[i-2];
		}
		
		int a_n = fibbo[D-2];
		int b_n = fibbo[D-1];
		
		int result_a = 0;
		int result_b = 0;
		for(int i=1, size=K/a_n; i<=size; i++) {
			if((K-a_n*i)%b_n == 0) {
				result_a = i;
				result_b = (K-a_n*i)/b_n;
				break; 
			}
		}

		System.out.println(result_a);
		System.out.println(result_b);
	}
}
