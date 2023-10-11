import java.util.*;
import java.io.*;

public class boj14503_로봇청소기_136ms {
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 0:북, 1:동, 2:남, 3:서
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 3~50
		int M = Integer.parseInt(st.nextToken()); // 3~50 
		
		st = new StringTokenizer(br.readLine()); 
		int r = Integer.parseInt(st.nextToken()); // 로봇청소기가 있는 칸의 좌표 
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken()); // 처음에 로봇 청소기가 바라보는 방향 
		
		int[][] place = new int[N][M]; // 0: 청소X, 1: 벽
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				place[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 청소하는 영역의 개수 구하기 
		// 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소
		// 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
			// 2-1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
			// 2-2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
		// 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
			// 3-1. 반시계 방향으로 90도 회전한다.
			// 3-2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
			// 3-3. 1번으로 돌아간다.
		
		while(true) {
			// 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소
			if(place[r][c] == 0) {
				place[r][c] = 2; 
			}
			
			boolean hasUnclean = false; // 주변 4칸 중 청소되지 않은 빈 칸이 있는지 여부 
			for(int i=0; i<4; i++) { // 방향 
				int nr = r+dir[i][0];
				int nc = c+dir[i][1];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue; 
				if(place[nr][nc] == 0) {
					hasUnclean = true; 
					break;
				}
			}
			
			if(hasUnclean) { // 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
				// 반시계 방향으로 90도 회전 
				d--; 
				if(d == -1) d = 3;
				// 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
				int nr = r+dir[d][0];
				int nc = c+dir[d][1];
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					if(place[nr][nc] == 0) {
						r = nr; 
						c = nc;
					}
				}
			} else { // 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
				int back_d = (d+2)%4; // 후진 방향 
				int nr = r+dir[back_d][0];
				int nc = c+dir[back_d][1];
				if(nr<0 || nr>=N || nc<0 || nc>=M || place[nr][nc]==1) { // 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면
					break; // 작동을 멈춘다. 
				}
				// 후진 
				r = nr;
				c = nc;
			}
		}
		
		int result = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(place[i][j] == 2) result++;
			}
		}
			
		System.out.println(result);
	}
}
