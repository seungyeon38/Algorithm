package class4_2;

import java.util.*;
import java.io.*; 

public class boj17144_미세먼지안녕_452ms {
	static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken()); // 6~50
		int C = Integer.parseInt(st.nextToken()); // 6~50
		int T = Integer.parseInt(st.nextToken()); // 1~1000
		
		int[][] grid = new int[R][C]; // 격자판 
		int cleaner_sr = -1; // 공기청정기 첫 칸 
		boolean find = false; // 공기청정기 찾았는지 여부 
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken()); // -1~1000
				if(grid[i][j] == -1 && !find) { 
					cleaner_sr = i;
					find = true; 
				}
			}
		}
		
		int n = 0;
		while(++n <= T) { // T초 
			// 미세먼지 확산, 모든 칸에서 동시에, 인접한 네 방향 
			int[][] temp_grid = new int[R][C];
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					temp_grid[i][j] = grid[i][j];
				}
			}
			
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(temp_grid[i][j] > 0) { // 미세먼지가 있는 칸 
						int amount = temp_grid[i][j]/5; 
						int cnt = 0;
						
						for(int d=0; d<4; d++) { // 네 방향으로 확산 
							int nr = i+dir[d][0];
							int nc = j+dir[d][1];
							
							if(nr<0 || nr>=R || nc<0 || nc>=C) continue; 
							if(temp_grid[nr][nc] == -1) continue; 
							
							grid[nr][nc] += amount; // 계산은 원래거에 
							cnt++;
						}
						
						grid[i][j] -= amount*cnt;
					}
				}
			}
			
			// 공기청정기 작동 
			// 위쪽 공기청정기는 반시계방향으로 순환, 아래쪽 공기청정기는 시계방향으로 순환 
			// 미세먼지가 바람의 방향대로 모두 한 칸씩 이동 
			// 공기청정기로 들어간 미세먼지는 모두 정화됨 
			
			// 위쪽 공기청정기 반시계방향 순환
			for(int r=cleaner_sr-1; r>0; r--) {
				grid[r][0] = grid[r-1][0];
			}
			
			for(int c=0; c<C-1; c++) {
				grid[0][c] = grid[0][c+1];
			}
			
			for(int r=0; r<cleaner_sr; r++) {
				grid[r][C-1] = grid[r+1][C-1];
			}
			
			for(int c=C-1; c>1; c--) {
				grid[cleaner_sr][c] = grid[cleaner_sr][c-1];
			}
			
			grid[cleaner_sr][1] = 0;
			
			for(int r=cleaner_sr+2; r<R-1; r++) {
				grid[r][0] = grid[r+1][0]; 
			}
			
			for(int c=0; c<C-1; c++) {
				grid[R-1][c] = grid[R-1][c+1];
			}
			
			for(int r=R-1; r>cleaner_sr+1; r--) {
				grid[r][C-1] = grid[r-1][C-1];
			}
			
			for(int c=C-1; c>1; c--) {
				grid[cleaner_sr+1][c] = grid[cleaner_sr+1][c-1];
			}
			
			grid[cleaner_sr+1][1] = 0;
		}
		
		int result = 0; 
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				result += grid[i][j];
			}
		}
		
		System.out.println(result+2);
	}
	
	public static void print(int[][] grid, int R, int C) {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println();
	}
}
