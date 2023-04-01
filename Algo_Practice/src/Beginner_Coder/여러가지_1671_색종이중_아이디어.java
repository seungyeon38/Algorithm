package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 여러가지_1671_색종이중_아이디어 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		boolean[][] paper = new boolean[102][102];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int sc = Integer.parseInt(st.nextToken());
			int sr = Integer.parseInt(st.nextToken());
		
			for(int c=sc+1, size=sc+10; c<=size; c++) {
				for(int r=sr+1, size2=sr+10; r<=size2; r++) {
					paper[r][c] = true; 
				}
			}
		}
		
		int result = 0;
		
		for(int i=1; i<=100; i++) {
			for(int j=1; j<=100; j++) {
				if(paper[i][j]) {
					if(!paper[i-1][j])
						result++;
					if(!paper[i+1][j])
						result++;
					if(!paper[i][j-1])
						result++;
					if(!paper[i][j+1])
						result++;
				}
			}
		}
		
		System.out.println(result);
	}
}
