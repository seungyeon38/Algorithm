package Algorithm;

import java.util.*;
import java.io.*;

public class q027_boj2178 {
	public static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static char[][] matrix; 
	public static int[][] dist; 
	public static int N, M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 100  
		M = Integer.parseInt(st.nextToken()); // 100 
		
		matrix = new char[N][M];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(matrix[i], '0');
		}
		
		dist = new int[N][M];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(dist[i], -1);
		}
		
		for(int r=0; r<N; r++) {
			char[] c_arr = br.readLine().toCharArray();
			
			for(int c=0; c<M; c++) {
				matrix[r][c] = c_arr[c];
			}
		}
		
		bfs(0, 0);
	}
	
	public static void bfs(int sr, int sc) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {sr, sc});
		dist[sr][sc] = 1;

		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = p[0] + dir[i][0];
				int nc = p[1] + dir[i][1];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					if(matrix[nr][nc] == '1' && dist[nr][nc] == -1) {
						queue.offer(new int[] {nr, nc});
						
						dist[nr][nc] = dist[p[0]][p[1]]+1;
					}
				}
			}
		}
		
		System.out.println(dist[N-1][M-1]);
	}
}
