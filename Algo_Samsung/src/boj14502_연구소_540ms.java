import java.util.*;
import java.io.*;

public class boj14502_연구소_540ms {
	static int max = 0; 
	static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken()); // 세로 크기 3~8
		int M = Integer.parseInt(st.nextToken()); // 가로 크기 3~8
		
		ArrayList<int[]> empty = new ArrayList<>();
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) empty.add(new int[] {i, j});
			}
		}
		
		// 바이러스 확산을 막기 위해 연구소에 벽을 세우려고 한다. 
		// 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 
		// 벽을 3개 새로 세우려고 한다. 
		// 안전 영역 크기의 최댓값 구하기 
		
		int empty_cnt = empty.size();
		buildWall(0, 0, new boolean[empty_cnt], map, empty_cnt, N, M, empty);
		
		System.out.println(max);
	}
	
	public static void buildWall(int idx, int cnt, boolean[] select, int[][] map, int total, int N, int M, ArrayList<int[]> empty) {
		if(cnt == 3) {
			// 현재 map 복사 
			int[][] temp = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					temp[i][j] = map[i][j];
				}
			}
			
			// 벽 3개 세우기 
			for(int i=0; i<total; i++) {
				if(!select[i]) continue; 
				int[] loc = empty.get(i);
				temp[loc[0]][loc[1]] = 1; 
			}

			spreadVirus(temp, N, M);

			int temp_cnt = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(temp[i][j] == 0) temp_cnt++;
				}
			}
			max = Math.max(max, temp_cnt);
			
			return; 
		}
		
		for(int i=idx; i<total; i++) {
			select[i] = true; 
			buildWall(i+1, cnt+1, select, map, total, N, M, empty);
			select[i] = false; 
		}
	}
	
	public static void spreadVirus(int[][] map, int N, int M) {
		boolean[][] visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 2 && !visited[i][j]) {
					visited[i][j] = true; 
					dfs(map, i, j, N, M, visited);
				}
			}
		}
	}
	
	public static void dfs(int[][] map, int r, int c, int N, int M, boolean[][] visited) {
		for(int d=0; d<4; d++) {
			int nr = r+dir[d][0];
			int nc = c+dir[d][1];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M) continue; 
			if(visited[nr][nc]) continue; 
			if(map[nr][nc] != 0) continue; 
			
			visited[nr][nc] = true; 
			map[nr][nc] = 2;
			dfs(map, nr, nc, N, M, visited);
		}
	}
}
