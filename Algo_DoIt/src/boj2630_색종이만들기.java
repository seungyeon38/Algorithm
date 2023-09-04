import java.util.*;
import java.io.*;

public class boj2630_색종이만들기 {
	static int blue_n, white_n;
	static int[][] grid; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 2, 4, 8, ..., 128
		StringTokenizer st;
		
		grid = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		calc(0, 0, N);
		
		System.out.println(white_n);
		System.out.println(blue_n);
	}
	
	public static void calc(int sr, int sc, int length) {
		// 기저조건: 다 같은 색이면 
		boolean flag = true; 
		int color = grid[sr][sc]; 
		for(int r=sr, size=r+length; r<size; r++) {
			for(int c=sc, size_c=c+length; c<size_c; c++) {
				if(color != grid[r][c]) {
					flag = false;
					break;
				}
			}
			if(!flag) break;
		}
		
		if(flag) {
			if(color == 0) white_n++;
			else blue_n++;
			
			return;
		}
		
		int half = length/2;
		
		calc(sr, sc, half);
		calc(sr+half, sc, half);
		calc(sr, sc+half, half);
		calc(sr+half, sc+half, half);
	}
}
