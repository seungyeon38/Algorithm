package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 여러가지_1438_색종이초 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 색종이 수 
		
		StringTokenizer st;
		
		boolean[][] paper = new boolean[100][100];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sc = Integer.parseInt(st.nextToken());
			int sr = Integer.parseInt(st.nextToken());
			
			for(int c=sc, size=sc+10; c<size; c++) {
				for(int r=sr, size2=sr+10; r<size2; r++) {
					paper[r][c] = true; 
				}
			}
		}
		
		int result = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(paper[i][j]) result++;
			}
		}
		
		System.out.println(result);
	}
}
