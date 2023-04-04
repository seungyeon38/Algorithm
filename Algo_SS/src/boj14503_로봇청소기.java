import java.util.*;
import java.io.*;

public class boj14503_로봇청소기 {
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북, 동, 남, 서 
	static int N, M;
	static int cnt;
	static int[][] grid;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken()); // 3~50
		M = Integer.parseInt(st.nextToken()); // 3~50 
		
		st = new StringTokenizer(br.readLine()); 
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken()); 
		int d = Integer.parseInt(st.nextToken()); // 0:북, 1:동, 2:남, 3:서 
		
		grid = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		calc(r, c, d);
		
		System.out.println(cnt);
	}
	
	public static void calc(int r, int c, int d) {
		if(grid[r][c] == 0) { // 현재 칸 청소 
			grid[r][c] = 2; // 청소하면 
			cnt++;
		}
		
		boolean flag = false; // 주변 4칸 중 청소할 곳이 있는지 여부 
		
		for(int i=0; i<4; i++) {
			int nr = r+dir[i][0];
			int nc = c+dir[i][1];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
			
			if(grid[nr][nc] == 0) {
				flag = true;
				break;
			}
		}
		
		if(flag) { // 주변 4칸 중 청소할 곳이 있는 경우
			int temp_d = d;
			for(int i=0; i<4; i++) {
				// 반시계 방향으로 90도 회전 
				temp_d = findNextDir(temp_d);
				// 빈 경우 한칸 전진 
				int nr = r+dir[temp_d][0];
				int nc = c+dir[temp_d][1];
				if(grid[nr][nc] == 0) {
					calc(nr, nc, temp_d);
					break;
				}
			}
		} else { // 주변 4칸 중 청소할 곳이 없는 경우 
			// 동-서(1-3), 남-북(2-0) +2%4
			int temp_d = (d+2)%4; // 후진 방향 
			int nr = r+dir[temp_d][0];
			int nc = c+dir[temp_d][1];
			if(grid[nr][nc] == 1) { // 벽이면 (후진 불가)
				return;
			} else { // 후진이 가능한 경우 
				calc(nr, nc, d);
			}
		}	
	}
	
	public static int findNextDir(int d) { // 반시계방향 : 동-북-서-남 (1-0-3-2)
		if(d == 0) return 3;
		else if(d == 1) return 0; 
		else if(d == 2) return 1;
		else if(d == 3) return 2;
		
		return -1;
 	}
}
