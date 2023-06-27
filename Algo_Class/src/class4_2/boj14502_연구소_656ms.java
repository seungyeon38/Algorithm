package class4_2;

import java.util.*;
import java.io.*;

public class boj14502_연구소_656ms {
	static int N, M; 
	static int[][] place; // 연구소 
	static int[][] temp_place; 
	static ArrayList<int[]> empty;
	static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	static int empty_cnt;
	static int[] picked; 
	static boolean[][] visited;
	static int result; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로 크기 3~8
		M = Integer.parseInt(st.nextToken()); // 가로 크기 3~8 
		
		place = new int[N][M]; // 연구소 ]
		empty = new ArrayList<int[]>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				place[i][j] = Integer.parseInt(st.nextToken());
				if(place[i][j] == 0) empty.add(new int[] {i, j});
			}
		}
		
		// 0:빈칸, 1:벽, 2:바이러스 
		// 새로 세울 수 있는 벽 3개 
		// 바이러스는 상하좌우로 인접한 빈칸으로 모두 퍼져나갈 수 있음. 
		// 안전 영역 크기의 최댓값 구하기 
		
		empty_cnt = empty.size();
		picked = new int[3];
		
		pick(0, 0);
		
		System.out.println(result);
	}
	
	public static void pick(int cnt, int sp) { // 0~empty_cnt 중 3개 선택 
		if(cnt == 3) {
			// 벽 3개 세우기
			for(int i=0; i<3; i++) {
				int[] pos = empty.get(picked[i]);
				place[pos[0]][pos[1]] = 1;
			}
			// 복제 
			temp_place = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					temp_place[i][j] = place[i][j];
				}
			}
			// 바이러스 퍼져나감 
			visited = new boolean[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(place[i][j]==2 && !visited[i][j]) { // 방문하지 않은 곳 
						bfs(i, j);
					}
				}
			}
			// 안전영역 세기 
			int temp = 0; 
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(temp_place[i][j] == 0) {
						temp++;
					}
				}
			}
			result = Math.max(result, temp);
			// 원상복구 
			for(int i=0; i<3; i++) {
				int[] pos = empty.get(picked[i]);
				place[pos[0]][pos[1]] = 0;
			}
			return; 
		}
		
		for(int i=sp; i<empty_cnt; i++) {
			picked[cnt] = i;
			pick(cnt+1, i+1);
		}
	}
	
	public static void bfs(int sr, int sc) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {sr, sc});
		visited[sr][sc] = true; 
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0]+dir[d][0];
				int nc = cur[1]+dir[d][1];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue; 
				if(visited[nr][nc]) continue; 
				
				if(temp_place[nr][nc] == 0) { // 빈칸이라면 
					visited[nr][nc] = true;
					temp_place[nr][nc] = 2;
					queue.add(new int[] {nr, nc});
				}
			}
		}
	}
}
