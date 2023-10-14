import java.util.*;
import java.io.*;

public class boj17822_원판돌리기_176ms {
	static int N, M;
	static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int nCnt; // 남아있는 숫자 개수 
	static boolean hasAdjNum; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 원판 개수 2~50
		M = Integer.parseInt(st.nextToken()); // 원판에 있는 수의 개수 2~50
		int T = Integer.parseInt(st.nextToken()); // 회전 횟수 1~50
		nCnt = N*M;
		
		int[][] grid = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken()); // 1~1000
			}
		}
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 2~N
			int d = Integer.parseInt(st.nextToken()); // 0, 1 (0: 시계, 1: 반시계)
			int k = Integer.parseInt(st.nextToken()); // 회전 칸 수 
			
			
			for(int i=x; i<=N; i+=x) {
				rotate(grid, i, d, k);
			}
			
			calc(grid);
		}
		
		int result = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(grid[i][j] == -1) continue; 
				
				result += grid[i][j];
			}
		}
		
		System.out.println(result);
	}

	// n번 원판을 d방향으로 k칸 회전 
	public static void rotate(int[][] grid, int n, int d, int k) {
		if(d == 1) {
			k = M-k;
		}
		n--;
		for(int i=0; i<k; i++) {
			int temp = grid[n][M-1];
			for(int j=M-1; j>0; j--) {
				grid[n][j] = grid[n][j-1];
			}
			grid[n][0] = temp;	
		}
	}
	
	// 원판에 수가 남아있을 때, 인접하면서 수가 같은 걸 찾아서 모두 지우기
	// 인접하면서 같은 수가 없는 경우, 원판에 적힌 수의 평균 구하고, 평균보다 큰 수에서 1을 빼고, 작은 수에는 1을 더하기 
	public static void calc(int[][] grid) {
		if(nCnt == 0) return;
		
		hasAdjNum = false; 
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(grid[i][j] == -1) continue;	
				dfs(i, j, grid, grid[i][j]);
			}
		}
		
		if(hasAdjNum) return; 
		
		// 인접하면서 같은 수가 없는 경우 
		calcAverage(grid);
	}
	
	public static void dfs(int r, int c, int[][] grid, int n) {
		for(int d=0; d<4; d++) {
			int nr = r+dir[d][0];
			int nc = c+dir[d][1];
			
			if(nr<0 || nr>=N) continue; 
			if(nc >= M) nc%=M;
			else if(nc < 0) nc+=M; 
			
			if(grid[nr][nc]!=n) continue; 
			
			hasAdjNum = true; // 인접한 수 있음 표시 
			grid[r][c] = -1;
			grid[nr][nc] = -1; // 인접한 수 지우기
			nCnt--;

			dfs(nr, nc, grid, n);
		}
	}
	
	public static void calcAverage(int[][] grid) {
		int sum = 0;
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(grid[i][j] == -1) continue; 
				sum += grid[i][j];
				cnt++;
			}
		}
		
		double aver = (double)sum/cnt;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(grid[i][j] == -1) continue; 
				
				if(grid[i][j] > aver) grid[i][j]--;
				else if(grid[i][j] < aver) grid[i][j]++;
			}
		}
	}
}
