import java.util.*;
import java.io.*;

public class codetree_꼬리잡기놀이_2022상반기2 {
	static int n, m, k;
	static int[][] grid; 
	static int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
	static ArrayList<Loc>[] teams;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("src/4_input_sample.txt"));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		n = Integer.parseInt(st.nextToken()); // 격자의 크기 2~20
		m = Integer.parseInt(st.nextToken()); // 팀의 개수 1~5
		k = Integer.parseInt(st.nextToken()); // 라운드 수 1~1000
		
		grid = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 0: 빈칸, 1: 머리사람, 2: 머리사람과 꼬리사람이 아닌 나머지, 3: 꼬리사람, 4: 이동 선
		
		teams = new ArrayList[m];
		// 한 칸씩 이동 
		// 머리사람, 꼬리사람을 알아야돼 
		for(int i=0; i<m; i++) {
			teams[i] = new ArrayList<Loc>();
		}
		
		// 초기화 
		init();
		
		for(int i=1; i<=k; i++) {
//			System.out.println("라운드 시작");
//			print();
			// 1. 먼저 각 팀은 머리사람을 따라서 한 칸 이동
//			move();
//			System.out.println("이동");
//			print();
			// 2. 각 라운드마다 공이 정해진 선을 따라 던져집니다. 
//			throwBall(i);
//			System.out.println("공 던진 후");
//			print();
			
			// 1. 먼저 각 팀은 머리사람을 따라서 한 칸 이동
			// 2. 각 라운드마다 공이 정해진 선을 따라 던져집니다. 

		}
	}
	
	public static class Loc{
		int x;
		int y;
		
		Loc(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static boolean isOutRange(int r, int c) {
		if(r<0 || r>=n || c<0 || c>=n) return true;
		
		return false; 
	}
	
	public static void init() {
		visited = new boolean[n][n];
		int team_idx = 0;
		
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				if(!visited[r][c] && grid[r][c]==1) { // 시작 
					teams[team_idx].add(new Loc(r, c));
					visited[r][c] = true; 
					
					for(int d=0; d<4; d++) {
						int nr = r+dir[d][0];
						int nc = c+dir[d][1];
						
						if(isOutRange(nr, nc)) continue; 
						if(grid[nr][nc] == 2) { // 여기서 출발 
							dfs(nr, nc, team_idx);
						}
					}
					
					team_idx++;
				}
			}
		}
	}
	
	public static void dfs(int r, int c, int team_idx) {
		teams[team_idx].add(new Loc(r, c));
		visited[r][c] = true; 
		
		for(int d=0; d<4; d++) {
			int nr = r+dir[d][0];
			int nc = c+dir[d][1];
			
			if(visited[nr][nc]) continue; 
			if(grid[nr][nc] == 0) continue;
			
			dfs(nr, nc, team_idx);
		}
	}
	
//	public static void init() { 
//		boolean[][] visited = new boolean[n][n];
//		int idx = 0;
//		
//		for(int r=0; r<n; r++) {
//			for(int c=0; c<n; c++) {
//				if(!visited[r][c] && grid[r][c] == 1) { 
//					teams[idx].add(new Loc(r, c)); // 머리사람 
//					visited[r][c] = true; 
//					
//					for(int d=0; d<4; d++) {
//						int nr = r+dir[d][0];
//						int nc = c+dir[d][1];
//						
//						if(isOutRange(nr, nc)) continue; 
//						if(grid[nr][nc] == 2) {
//							while(grid[nr][nc] == 2) {
//								teams[idx].add(new Loc(nr, nc)); // 중간 사람 
//								visited[nr][nc] = true; 
//								
//								for(d=0; d<4; d++) {
//									int nnr = nr+dir[d][0];
//									int nnc = nc+dir[d][1];
//									
//									if(isOutRange(nnr, nnc)) continue; 
//									if(!visited[nnr][nnc] && grid[nnr][nnc] == 2) {
//										nr = nnr; 
//										nc = nnc;
//										break; 
//									}
//								}
//							}
//							teams[idx].add(new Loc(nr, nc)); // 꼬리사람 
//							
//							break;
//						}
//					}
//					
//					idx++;
//				}
//			}
//		}
//	}
	
	public static void move() {
		for(int i=0; i<m; i++) {
			ArrayList<Loc> team = teams[i];
			
			Loc head = team.get(0);
			
			for(int p=1, size=team.size(); p<size; p++) {
				// 이전으로 
				team.set(p-1, team.get(p));
			}
			
			team.set(team.size()-1, head);
		}
		
		for(int i=0; i<m; i++) {
			ArrayList<Loc> players = teams[i];
			grid[players.get(0).x][players.get(0).y] = 1;
			
			for(int j=1, size=players.size()-1; j<size; j++) {
				grid[players.get(j).x][players.get(j).y] = 2;
			}
			
			grid[players.get(players.size()-1).x][players.get(players.size()-1).y] = 3;
		}
	}
	
//	public static void print() {
//		for(int i=0; i<n; i++) {
//			System.out.println(Arrays.toString(grid[i]));
//		}
//		System.out.println();
//	}
	
	
//	
//	public static boolean isOutRange(int r, int c) {
//		if(r<0 || r>=n || c<0 || c>=n) return true; 
//		
//		return false; 
//	}
	
//	public static void move() {
////		initVisited();
//		
//		// 1 2 2 2 3 
//		// 머리 사람은 이동선을 따라 이동 
//		int br = 0; 
//		int bc = 0;
//		int sr = 0;
//		int sc = 0; 
//		
//		for(int r=0; r<n; r++) {
//			for(int c=0; c<n; c++) {
//				if(!visited[r][c] && grid[r][c] == 1) {
//					visited[r][c] = true; 
//					int cur_d;
//					
//					for(int d=0; d<4; d++) {
//						int nr = r+dir[d][0];
//						int nc = c+dir[d][1];
//						
//						if(isOutRange(nr, nc)) continue; 
//						if(grid[nr][nc] == 2) {
//							cur_d = d;
//							break;
//						}
//					}
//					
//					
//				}
//			}
//		}
//	}

//	public static void throwBall(int round) {
////		initVisited();
//		int d = (round-1)/n%4; 
//		int s = (round-1)%n;
//		
//		switch(d) {
//		case 0:
//			// (s, 0)부터 시작 ~(s, n-1)
//			for(int c=0; c<n; c++) {
//				if(grid[s][c]==1 || grid[s][c]==2 || grid[s][c]==3) { // 사람 
//					result += getScore(s, c);
//					changeOrder(s, c);
//					break; 
//				}
//			}
//			break; 
//		case 1:
//			// (n-1, s)~(0, s)
//			for(int r=n-1; r>=0; r--) {
//				if(grid[r][s]==1 || grid[r][s]==2 || grid[r][s]==3) { // 사람 
//					result += getScore(r, s);
//					changeOrder(r, s);
//					break; 
//				}
//			}
//			break;
//		case 2:
//			// (n-1-s, n-1)~(n-1-s, 0)
//			s = n-1-s;
//			for(int c=n-1; c>=0; c--) {
//				if(grid[s][c]==1 || grid[s][c]==2 || grid[s][c]==3) { // 사람 
//					result += getScore(s, c);
//					changeOrder(s, c);
//					break; 
//				}
//			}
//			break; 
//		case 3:
//			// (0, n-1-s)~(n-1, n-1-s)
//			s = n-1-s;
//			for(int r=0; r<n; r++) {
//				if(grid[r][s]==1 || grid[r][s]==2 || grid[r][s]==3) { // 사람 
//					result += getScore(r, s);
//					changeOrder(r, s);
//					break; 
//				}
//			}
//			break; 
//		}
//	}
	
//	public static int getScore(int r, int c) {
//		getOrder(r, c, 1);
//		
//		return (int)Math.pow(order, 2);
//	}
	
//	public static void getOrder(int r, int c, int k) {
//		// 해당 사람이 있는 곳의 머리사람 찾기 
//		if(grid[r][c] == 1) {
//			order = k;
//			return;
//		}
//		
//		visited[r][c] = true; 
//		
//		for(int d=0; d<4; d++) {
//			int nr = r+dir[d][0];
//			int nc = c+dir[d][1];
//		
//			if(isOutRange(nr, nc)) continue; 
//			if(visited[nr][nc]) continue; 
//			
//			if(grid[nr][nc]==1 || grid[nr][nc]==2) {
//				visited[nr][nc] = true;
//				getOrder(nr, nc, k+1);
//				visited[nr][nc] = false;
//			}
//		}
//	}
	
//	public static void changeOrder(int r, int c) {
////		System.out.println("시작: (" + r + ", " + c + ")");
//
//		// (r,c)가 있는 팀의 머리와 꼬리사람이 바뀜 
//		initVisited();
//		getHead(r, c);
//		initVisited();
//		getTail(r, c);
//		
//		grid[head_r][head_c] = 3;
//		grid[tail_r][tail_c] = 1;
//	}
	
//	public static void getHead(int r, int c) {
////		System.out.println("(r, c): (" + r + ", " + c + ")");
//		if(grid[r][c] == 1) {
//			head_r = r; 
//			head_c = c;
//			return; 
//		}
//		
//		visited[r][c] = true; 
//		
//		for(int d=0; d<4; d++) {
//			int nr = r+dir[d][0];
//			int nc = c+dir[d][1];
//			
//			if(isOutRange(nr, nc)) continue; 
//			if(visited[nr][nc]) continue; 
//			
//			if(grid[nr][nc]==1 || grid[nr][nc]==2){
//				visited[nr][nc] = true; 
//				getHead(nr, nc);
//			}
//		}
//		
//		return; 
//	}
//	
//	public static void getTail(int r, int c) {
//		if(grid[r][c] == 3) {
//			tail_r = r; 
//			tail_c = c;
//			return; 
//		}
//		
//		visited[r][c] = true; 
//		
//		for(int d=0; d<4; d++) {
//			int nr = r+dir[d][0];
//			int nc = c+dir[d][1];
//			
//			if(isOutRange(nr, nc)) continue; 
//			if(visited[nr][nc]) continue; 
//			
//			if(grid[nr][nc]==2 || grid[nr][nc]==3){
//				visited[nr][nc] = true; 
//				getTail(nr, nc);
//			}
//		}
//		
//		return;
//	}
	
//	public static void initVisited() {
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				visited[i][j] = false; 
//			}
//		}
//	}
}
