import java.util.*;
import java.io.*;

public class boj21608_상어초등학교 {
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 3~20
		int[][] student_likes = new int[N*N+1][4]; // 좋아하는 학생 번호 
		int[] order = new int[N*N]; // 배치해야하는 학생 순서 
		
		for(int i=0, size=N*N; i<size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int stu = Integer.parseInt(st.nextToken());
			order[i] = stu;
			
			for(int j=0; j<4; j++) {
				student_likes[stu][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		int[][] grid = new int[N][N]; // 배치
		int[][] student_loc = new int[N*N+1][2]; // 배치된 학생 위치 
		
		for(int i=0, size=N*N; i<size; i++) {
			int[][] empty = new int[N][N]; // 주변에 비어있는 칸의 개수 
			int[][] like = new int[N][N]; // 주변에 친한 친구가 많은 위치를 찾기 위한 배열 
			
			// empty 초기화 
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					for(int d=0; d<4; d++) {
						int nr = r+dir[d][0];
						int nc = c+dir[d][1];
						
						if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
						
						if(grid[nr][nc] == 0) {
							empty[r][c]++;
						}
					}
				}
			}
			
			int stu = order[i]; // 배치해야할 학생 
			
			for(int j=0; j<4; j++) {
				int student_like = student_likes[stu][j];
				if(student_loc[student_like] != null) {
					for(int d=0; d<4; d++) {
						int nr = student_loc[student_like][0]+dir[d][0];
						int nc = student_loc[student_like][1]+dir[d][1];
						
						if(nr<0 || nr>=N || nc<0 || nc>=N) continue;

						like[nr][nc]++;
					}
				}
			}
			
			int max_like = 0;
			int empty_like = 0;
			int loc_r = -1;
			int loc_c = -1;
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(grid[r][c] != 0) continue;
					if(max_like < like[r][c]) { // 1. 좋아하는 학생이 인접한 칸에 가장 많은 칸 
						max_like = like[r][c];
						empty_like = empty[r][c];
						loc_r = r;
						loc_c = c;
					} else if(max_like==like[r][c] && empty[r][c]>empty_like) { // 2. 인접한 칸 중에서 비어있는 칸이 가장 많은 칸 
						empty_like = empty[r][c];
						loc_r = r;
						loc_c = c;
					}
				}
			}
			
			student_loc[stu] = new int[] {loc_r, loc_c};
			grid[loc_r][loc_c] = stu;
		}
		
		// 학생 만족도의 총 합 
		int result = 0; 
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				int cnt = 0;
				for(int d=0; d<4; d++) {
					int nr = r+dir[d][0];
					int nc = c+dir[d][1];
					
					if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
					
					for(int i=0; i<4; i++) {
						if(grid[nr][nc] == student_likes[grid[r][c]][i]) {
							cnt++;
							break; 
						}
					}
				}
				
				if(cnt > 0) result += Math.pow(10, cnt-1);
			}
		}
		
		System.out.println(result);
	}
}
