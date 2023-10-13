import java.util.*;
import java.io.*;

public class boj15685_드래곤커브_172ms {
	static int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
	static int cx;
	static int cy;
	static int sx;
	static int sy;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); 
		boolean[][] grid = new boolean[101][101];
				
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 드래곤 커브 시작점 0~100
			int y = Integer.parseInt(st.nextToken()); 
			int d = Integer.parseInt(st.nextToken()); // 시작 방향 0~3
			int g = Integer.parseInt(st.nextToken()); // 세대 0~10
			
			sx = x;
			sy = y;
			cx = x+dir[d][1];
			cy = y+dir[d][0];
			boolean[][] temp_grid = new boolean[101][101];
			temp_grid[sy][sx] = true;
			temp_grid[cy][cx] = true;

			for(int j=0; j<g; j++) {
				rotate(temp_grid);
			}
			
			for(int j=0; j<=100; j++) {
				for(int k=0; k<=100; k++) {
					if(temp_grid[j][k]) grid[j][k] = true;
				}
			}
		}
		
		int result = 0;
		for(int x=0; x<100; x++) {
			for(int y=0; y<100; y++) {
				if(grid[y][x] && grid[y][x+1] && grid[y+1][x] && grid[y+1][x+1]) result++;
			}
		}
		
		System.out.println(result);
	}
	
	// (cx, cy)를 중심으로 cur에 있는 점들을 90도 시계방향 회전 (원래 점은 그대로 두기)
	public static void rotate(boolean[][] cur) {
		int next_cx=0;
		int next_cy=0;
		
		ArrayList<int[]> move_list = new ArrayList<>();
		for(int x=0; x<=100; x++) {
			for(int y=0; y<=100; y++) {
				if(x==cx && y==cy) continue; 
				if(cur[y][x]) {
					// 회전 
					// 현재 차이 
					int cur_diff_x = cx-x;
					int cur_diff_y = cy-y;
					
					// 회전 후 차이 
					int next_diff_x = cur_diff_y;
					int next_diff_y = -cur_diff_x;
					
					move_list.add(new int[] {cy+next_diff_y, cx+next_diff_x});
					
					if(x==sx && y==sy) {
						next_cx = cx+next_diff_x;
						next_cy = cy+next_diff_y;
					}
				}
			}
		}
		
		for(int[] move : move_list) {
			cur[move[0]][move[1]] = true;
		}
		
		cx = next_cx;
		cy = next_cy;
	}
}
