import java.util.*;
import java.io.*;

public class boj21608_상어초등학교_212ms {
	static int N;
	static int[][] room;
	static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 교실 크기 3~20
		room = new int[N][N]; // 교실 
		int[][] stu_like = new int[N*N+1][4]; // 좋아하는 학생 
		
		for(int i=0, stu_cnt=N*N; i<stu_cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int stu_n = Integer.parseInt(st.nextToken()); // 학생 번호 
			for(int j=0; j<4; j++) {
				stu_like[stu_n][j] = Integer.parseInt(st.nextToken()); 
			}
			arrangeStudent(stu_n, stu_like[stu_n]);
		}
		
		int[] satisfaction_cnt = new int[5]; // 만족도 세기 
		calcSatisfaction(stu_like, satisfaction_cnt);
		
		int result = 0;
		for(int i=1; i<5; i++) {
			result += Math.pow(10, i-1)*satisfaction_cnt[i];
		}
		
		System.out.println(result);
	}
	
	public static void print(String str) {
		StringBuilder sb = new StringBuilder();
		sb.append(str).append("\n");
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(room[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void calcSatisfaction(int[][] stu_like, int[] result) {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				int stu_n = room[r][c]; // 학생 번호 
				int cnt = 0; // 만족도 
				for(int d=0; d<4; d++) {
					int nr = r+dir[d][0];
					int nc = c+dir[d][1];
					
					if(nr<0 || nr>=N || nc<0 || nc>=N) continue; 
					int[] like = stu_like[stu_n]; // 좋아하는 학생 
					
					for(int i=0; i<4; i++) {
						if(like[i] == room[nr][nc]) {
							cnt++;
							break; 
						}
					}
				}
				
				result[cnt]++;
			}
		}
	}
	
	public static void arrangeStudent(int stu, int[] stu_like) {
		ArrayList<int[]> most_like = new ArrayList<>(); // 좋아하는 학생 수가 많은 칸 
		int[][] empty_cnt = new int[N][N]; // 인접한 칸이 비어있는 개수 
		int max_like_cnt = 0;
	
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(room[r][c] != 0) continue; // 비어있는 칸이 아니라면 
				
				int like_cnt = 0; // 인접한 칸의 좋아하는 사람 수 
			
				for(int d=0; d<4; d++) {
					int nr = r+dir[d][0];
					int nc = c+dir[d][1];
					if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
					if(room[nr][nc] == 0) {
						empty_cnt[r][c]++;
						continue;
					}
					for(int i=0; i<4; i++) {
						if(stu_like[i] == room[nr][nc]) {
							like_cnt++;
							break;
						}
					}
				}
				
				if(max_like_cnt < like_cnt) {
					max_like_cnt = like_cnt;
					most_like.clear();
					most_like.add(new int[] {r, c});
				} else if(max_like_cnt == like_cnt) {
					most_like.add(new int[] {r, c});
				}
			}
		}
		
		int[] move = new int[2];
		if(most_like.size() == 1) {
			move = most_like.get(0);
		} else {
			int max_empty = -1;
			for(int[] like_loc : most_like) {
				if(max_empty < empty_cnt[like_loc[0]][like_loc[1]]) {
					max_empty = empty_cnt[like_loc[0]][like_loc[1]];
					move = like_loc;
				}
			}
		}
		
		room[move[0]][move[1]] = stu;
	}
}
