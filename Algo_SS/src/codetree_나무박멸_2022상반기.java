import java.util.*;
import java.io.*;

public class codetree_나무박멸_2022상반기 {
	static int n, m, k, c;
	static int[][] grid; 
	static int[][] dir1 = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상하좌우 
	static int[][] dir2 = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}}; // 대각선 
	static int[][] pests; // 제초제 남은 년 수 
	static int result; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 격자의 크기 5~20
		m = Integer.parseInt(st.nextToken()); // 박멸 진행 년 수 1~1000
		k = Integer.parseInt(st.nextToken()); // 제초제 확산 범위 1~20 
		c = Integer.parseInt(st.nextToken()); // 제초제 남아있는 년 수 1~10
		
		// 총 나무의 그루 수는 1~100
		
		grid = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<n; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		pests = new int[n][n];
				
		for(int y=0; y<m; y++) { // 박멸 진행 년 수 
			// 1. 인접한 네 개의 칸 중 나무가 있는 칸의 수만큼 나무가 성장. 모든 나무가 동시에 성장.
			grow();
			// 2. 기존에 있었던 나무들은 인접한 4개의 칸 중 벽, 다른 나무, 제초제 모두 없는 칸에 번식을 진행.
			// 이때 각 칸의 나무 그루 수에서 총 번식이 가능한 칸의 개수만큼 나누어진 그루 수만큼 번식이 되며, 나눌 때 생기는 나머지는 버림. 
			// 번식의 과정은 모든 나무에서 동시에 일어나게 됩니다.
			breed();
			// 3. 각 칸 중 제초제를 뿌렸을 때 나무가 가장 많이 박멸되는 칸에 제초제를 뿌립니다. 
			int[] loc = calc(); // 제초제 뿌릴 곳 
			// 나무가 없는 칸에 제초제를 뿌리면, 박멸되는 나무가 전혀 없는 상태로 끝이 나지만, 
			// 나무가 있는 칸에 제초제를 뿌리게 되면, 4개의 대각선 방향으로 k칸만큼 전파되게 됩니다. 
			// 단, 전파되는 도중 벽이 있거나 나무가 아예 없는 칸이 있는 경우, 그 칸 까지는 제초제가 뿌려지며 그 이후의 칸으로는 제초제가 전파되지 X
			// 제초제가 뿌려진 칸에는 c년만큼 제초제가 남아있다가 c+1년째가 될 때 사라지게 됩니다. 
			// 제초제가 뿌려진 곳에 다시 제초제가 뿌려지는 경우에는 새로 뿌려진 해로부터 다시 c년동안 제초제가 유지됩니다.
			disappear();
			if(loc[0]==-1 && loc[1]==-1) continue;

			spread(loc);
		}
		
		System.out.println(result);
	}
	
	public static boolean out(int r, int c) {
		if(r<0 || r>=n || c<0 || c>=n) return true; 
		
		return false; 
	}
	
	public static boolean stop(int r, int c) {
		if(grid[r][c]==0 || grid[r][c]==-1) return true; // 벽이 있거나 나무가 아예 없는 칸인 경우 
		return false; 
	}
	
	// 1. 인접한 네 개의 칸 중 나무가 있는 칸의 수만큼 나무가 성장. 모든 나무가 동시에 성장.
	public static void grow() {
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				if(grid[r][c] > 0) { // 나무가 있으면 
					int cnt = 0;
					for(int d=0; d<4; d++) {
						int nr = r+dir1[d][0];
						int nc = c+dir1[d][1];
						if(out(nr, nc)) continue;
						if(grid[nr][nc] > 0) cnt++;
					}
					grid[r][c] += cnt; 
				}
			}
		}
	}
	
	// 2. 기존에 있었던 나무들은 인접한 4개의 칸 중 벽, 다른 나무, 제초제 모두 없는 칸에 번식을 진행.
	// 이때 각 칸의 나무 그루 수에서 총 번식이 가능한 칸의 개수만큼 나누어진 그루 수만큼 번식이 되며, 나눌 때 생기는 나머지는 버림. 
	// 번식의 과정은 모든 나무에서 동시에 일어나게 됩니다.
	public static void breed() {
		// 동시에 일어나게 된다. 
		// 배열 복사 
		int[][] before = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				before[i][j] = grid[i][j];
			}
		}
		
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				if(before[r][c] > 0) { // 나무가 있으면 
					int cnt = 0; // 벽, 다른 나무, 제초제가 없는 칸 
					for(int d=0; d<4; d++) {
						int nr = r+dir1[d][0];
						int nc = c+dir1[d][1];
						if(out(nr, nc)) continue; 
						if(pests[nr][nc] > 0) continue;
						if(before[nr][nc] == 0) {
							cnt++;
						}
					}
					if(cnt != 0) { // 빈 칸이 있으면 
						int n = before[r][c]/cnt;
						for(int d=0; d<4; d++) {
							int nr = r+dir1[d][0];
							int nc = c+dir1[d][1];
							if(out(nr, nc)) continue; 
							if(pests[nr][nc] > 0) continue;
							if(before[nr][nc]==0) {
								grid[nr][nc] += n; // 업데이트만 원본에 
							}
						}
					}
				}
			}
		}
	}
	
	// 나무가 가장 많이 박멸되는 칸 구하기 
	public static int[] calc() {
		int max = 0; 
		int max_r = -1; 
		int max_c = -1; 
		
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				if(grid[r][c] > 0) { // 나무가 있으면 
					int cnt = grid[r][c];
					for(int d=0; d<4; d++) { // 대각선 
						for(int i=1; i<=k; i++) { // 대각선 타고 가는 횟수 
							int nr = r + dir2[d][0]*i;
							int nc = c + dir2[d][1]*i;
							if(out(nr, nc)) break; 
							if(stop(nr, nc)) break;  // 벽이거나 나무가 없는 부분이면 전파 중단 
							cnt += grid[nr][nc];
						}
					}
					if(max < cnt) {
						max = cnt; 
						max_r = r; 
						max_c = c;
					}
				}
			}
		}
		
		return new int[] {max_r, max_c};
	}
	
	public static void spread(int[] loc) {
		// 4개의 대각선 방향으로 k만큼 전파 
		// 단, 전파되는 도중 벽이 있거나 나무가 아예 없는 칸이 있는 경우, 그 칸 까지는 제초제가 뿌려지며 그 이후의 칸으로는 제초제가 전파되지 X
		if(grid[loc[0]][loc[1]] > 0) result += grid[loc[0]][loc[1]];
		grid[loc[0]][loc[1]] = 0;
		pests[loc[0]][loc[1]] = c;
		
		for(int d=0; d<4; d++) {
			for(int i=1; i<=k; i++) {
				int nr = loc[0]+dir2[d][0]*i;
				int nc = loc[1]+dir2[d][1]*i;
				
				if(out(nr, nc) || grid[nr][nc]==-1) break;

				result += grid[nr][nc];
				
				if(grid[nr][nc] == 0) {
					pests[nr][nc] = c;				
					break; 
				}
				
				grid[nr][nc] = 0; 
				pests[nr][nc] = c;
			}
		}
	}
	
	public static void disappear() {
		// 제초제가 뿌려진 칸에는 c년만큼 제초제가 남아있다가 c+1년째가 될 때 사라지게 됩니다. 
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				if(pests[r][c] > 0) {
					pests[r][c]--;
				}
			}
		}
	}
}
