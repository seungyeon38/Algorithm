package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여러가지_1761_숫자야구_모르겠 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		String[] game = new String[N];
		int[] strike = new int[N];
		int[] ball = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			game[i] = st.nextToken();
			strike[i] = Integer.parseInt(st.nextToken());
			ball[i] = Integer.parseInt(st.nextToken());
		}
		
		
	}
	
	public static void perm(int[] set, int depth, int n, int k) {
		if(depth == k) {
			
		}
	}
}
