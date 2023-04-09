import java.util.*;
import java.io.*;

public class codetree_꼬리잡기놀이_2022상반기 {
	static int n, m, k;
	static int[][] grid; 
	static int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
	static boolean[][] visited; 
	static int order; 
	static int result; 
	static int head_r, head_c;
	static int tail_r, tail_c;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		n = Integer.parseInt(st.nextToken()); // 격자의 크기 2~20
		m = Integer.parseInt(st.nextToken()); // 팀의 개수 1~5
		k = Integer.parseInt(st.nextToken()); // 라운드 수 1~1000
		
		grid = new int[n][n];
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 0: 빈칸, 1: 머리사람, 2: 머리사람과 꼬리사람이 아닌 나머지, 3: 꼬리사람, 4: 이동 선
		
		for(int i=1; i<=k; i++) {
			System.out.println("라운드 시작");
			print();
			// 1. 먼저 각 팀은 머리사람을 따라서 한 칸 이동
			move();
			System.out.println("이동");
			print();
			// 2. 각 라운드마다 공이 정해진 선을 따라 던져집니다. 
			throwBall(i);
			System.out.println("공 던진 후");
			print();
		}
		
		System.out.println(result);
	}
	
	public static void print() {
		for(int i=0; i<n; i++) {
			System.out.println(Arrays.toString(grid[i]));
		}
		System.out.println();
	}
	
	public static boolean isOutRange(int r, int c) {
		if(r<0 || r>=n || c<0 || c>=n) return true; 
		
		return false; 
	}
	
	public static void move() {
		initVisited();
		
		// 1 2 2 2 3 
		// 머리 사람은 이동선을 따라 이동 
		int br = 0; 
		int bc = 0;
		int sr = 0;
		int sc = 0; 
		
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				if(!visited[r][c] && grid[r][c] == 1) {
					visited[r][c] = true; 
					
					for(int d=0; d<4; d++) {
						int nr = r+dir[d][0];
						int nc = c+dir[d][1];
						
						if(isOutRange(nr, nc)) continue; 
						
						if(grid[nr][nc] == 3) { // 머리와 꼬리가 붙어있는 경우 
							visited[nr][nc] = true; 
							grid[nr][nc] = 1;
							
						}
						if(grid[nr][nc] == 4) { // 다음 칸으로 이동 
							visited[nr][nc] = true; 
							grid[nr][nc] = 1; 
						}
						if(grid[nr][nc] == 2) { // 뒷 사람이 이 칸으로 이동 
							visited[nr][nc] = true; 
							grid[r][c] = 2; 
							br = r;
							bc = c;
							sr = nr; 
							sc = nc; 
						}
					}
					// 머리사람, 그 다음 사람까지 이동 완료 
					
					// sr, sc 부터 꼬리사람이 나올 때까지 
					boolean flag = true; 
					while(flag) {
						for(int d=0; d<4; d++) { // 4방향 다 둘러보기 
							int nr = sr+dir[d][0]; 
							int nc = sc+dir[d][1];
							if(nr==br && nc==bc) continue; 
							if(isOutRange(nr, nc)) continue;
							if(visited[nr][nc]) continue;
							if(grid[nr][nc] == 2) {
								br = sr;
								bc = sc;
								sr = nr;
								sc = nc; 
							} else if(grid[nr][nc] == 3) {
								grid[sr][sc] = 3;
								grid[nr][nc] = 4;
								flag = false; 
							}
						}
					}
				}
			}
		}
	}

	public static void throwBall(int round) {
		initVisited();
		int d = (round-1)/n%4; 
		int s = (round-1)%n;
		
		switch(d) {
		case 0:
			// (s, 0)부터 시작 ~(s, n-1)
			for(int c=0; c<n; c++) {
				if(grid[s][c]==1 || grid[s][c]==2 || grid[s][c]==3) { // 사람 
					result += getScore(s, c);
					changeOrder(s, c);
					break; 
				}
			}
			break; 
		case 1:
			// (n-1, s)~(0, s)
			for(int r=n-1; r>=0; r--) {
				if(grid[r][s]==1 || grid[r][s]==2 || grid[r][s]==3) { // 사람 
					result += getScore(r, s);
					changeOrder(r, s);
					break; 
				}
			}
			break;
		case 2:
			// (n-1-s, n-1)~(n-1-s, 0)
			s = n-1-s;
			for(int c=n-1; c>=0; c--) {
				if(grid[s][c]==1 || grid[s][c]==2 || grid[s][c]==3) { // 사람 
					result += getScore(s, c);
					changeOrder(s, c);
					break; 
				}
			}
			break; 
		case 3:
			// (0, n-1-s)~(n-1, n-1-s)
			s = n-1-s;
			for(int r=0; r<n; r++) {
				if(grid[r][s]==1 || grid[r][s]==2 || grid[r][s]==3) { // 사람 
					result += getScore(r, s);
					changeOrder(r, s);
					break; 
				}
			}
			break; 
		}
	}
	
	public static int getScore(int r, int c) {
		getOrder(r, c, 1);
		
		return (int)Math.pow(order, 2);
	}
	
	public static void getOrder(int r, int c, int k) {
		// 해당 사람이 있는 곳의 머리사람 찾기 
		if(grid[r][c] == 1) {
			order = k;
			return;
		}
		
		visited[r][c] = true; 
		
		for(int d=0; d<4; d++) {
			int nr = r+dir[d][0];
			int nc = c+dir[d][1];
		
			if(isOutRange(nr, nc)) continue; 
			if(visited[nr][nc]) continue; 
			
			if(grid[nr][nc]==1 || grid[nr][nc]==2) {
				visited[nr][nc] = true;
				getOrder(nr, nc, k+1);
				visited[nr][nc] = false;
			}
		}
	}
	
	public static void changeOrder(int r, int c) {
//		System.out.println("시작: (" + r + ", " + c + ")");

		// (r,c)가 있는 팀의 머리와 꼬리사람이 바뀜 
		initVisited();
		getHead(r, c);
		initVisited();
		getTail(r, c);
		
		grid[head_r][head_c] = 3;
		grid[tail_r][tail_c] = 1;
	}
	
	public static void getHead(int r, int c) {
//		System.out.println("(r, c): (" + r + ", " + c + ")");
		if(grid[r][c] == 1) {
			head_r = r; 
			head_c = c;
			return; 
		}
		
		visited[r][c] = true; 
		
		for(int d=0; d<4; d++) {
			int nr = r+dir[d][0];
			int nc = c+dir[d][1];
			
			if(isOutRange(nr, nc)) continue; 
			if(visited[nr][nc]) continue; 
			
			if(grid[nr][nc]==1 || grid[nr][nc]==2){
				visited[nr][nc] = true; 
				getHead(nr, nc);
			}
		}
		
		return; 
	}
	
	public static void getTail(int r, int c) {
		if(grid[r][c] == 3) {
			tail_r = r; 
			tail_c = c;
			return; 
		}
		
		visited[r][c] = true; 
		
		for(int d=0; d<4; d++) {
			int nr = r+dir[d][0];
			int nc = c+dir[d][1];
			
			if(isOutRange(nr, nc)) continue; 
			if(visited[nr][nc]) continue; 
			
			if(grid[nr][nc]==2 || grid[nr][nc]==3){
				visited[nr][nc] = true; 
				getTail(nr, nc);
			}
		}
		
		return;
	}
	
	public static void initVisited() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				visited[i][j] = false; 
			}
		}
	}
}
