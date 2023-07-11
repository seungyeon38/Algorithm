package class4_2;

import java.util.*;
import java.io.*;
 
public class boj16236_아기상어_136ms {
	static int N;
	static int[][] place; 
	static int baby_size = 2; 
	static int baby_r;
	static int baby_c; 
	static int eat_cnt = 0;
	static int eat_total_time = 0;
	static int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}}; // 위, 왼쪽 우선 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 공간의 크기 2~20 
		place = new int[N][N];
		baby_r = 0;
		baby_c = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				place[i][j] = Integer.parseInt(st.nextToken());
				if(place[i][j] == 9) { // 아기 상어 위치 
					baby_r = i;
					baby_c = j;
				}
			}
		}
		
		// 아기 상어가 물고기를 잡아먹을 수 있는 시간 
		
		// 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없음 
		// 자신의 크기보다 작은 물고기만 먹을 수 있음 
		
		// 먹을 수 있는 물고기가 1마리 남아있으면, 그 물고기를 먹으러 감 
		// 					여러 마리면, 거리가 가장 가까운 물고기를 먹으러 감 
		
		// bfs로 최단 거리에 있는 물고기 찾기 
		// 먹을 수 있는 물고기가 없을 때까지 반복 
		// 자신보다 크기가 큰 물고기 밖에 없거나 물고기가 없을 때까지 
		while(true) {
			boolean eat = bfs_eat();
			if(!eat) break;
		}
		
		System.out.println(eat_total_time);
	}
	
	public static boolean bfs_eat() { // 먹을 물고기 찾기 
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {baby_r, baby_c});
		boolean[][] visited = new boolean[N][N];
		visited[baby_r][baby_c] = true; 
		boolean eat = false; 
		int temp_time = 0;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
				int r1 = o1[0];
				int c1 = o1[1];
				int r2 = o2[0];
				int c2 = o2[1];
				
				if(r1 != r2) {
					return r1-r2;
				} else {
					return c1-c2;
				}
			});
			temp_time++;
			
			while(n-- > 0) {
				int[] cur = queue.poll();
				
				for(int d=0; d<4; d++) {
					int nr = cur[0]+dir[d][0];
					int nc = cur[1]+dir[d][1];
					
					if(nr<0 || nr>=N || nc<0 || nc>=N) continue; 
					if(visited[nr][nc]) continue; 
					
					// 먹을 수 있는 물고기 있는지 확인 
					// 자신의 크기보다 작은 물고기만 먹을 수 있음 
					if(place[nr][nc]>0 && place[nr][nc]<7 && place[nr][nc]<baby_size) {
						pq.add(new int[] {nr, nc}); // 먹을 수 있는 물고기 후보 
						eat = true; 
					}
					
					// 지나갈 수 있는 곳이면 이동 
					if(place[nr][nc] <= baby_size) {
						visited[nr][nc] = true; 
						queue.add(new int[] {nr, nc});
					}
				}
			}
			
			if(eat) {
				int[] eat_fish = pq.poll(); // 먹을 물고기 
				
				// 먹기 
				eat_total_time += temp_time; 
				place[eat_fish[0]][eat_fish[1]] = 0; 
				// 이동 
				place[baby_r][baby_c] = 0;
				baby_r = eat_fish[0]; 
				baby_c = eat_fish[1]; 
				
				// 개수 세기 
				eat_cnt++; 
				// 자신의 크기와 같은 수의 물고기를 먹을 때마다 크기가 1 증가 
				if(eat_cnt == baby_size) { 
					baby_size++;
					eat_cnt = 0;
				}
				
				break;
			}
		}
		
		return eat;
	}
}
