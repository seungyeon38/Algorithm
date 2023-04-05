import java.util.*;
import java.io.*;

public class boj21608_상어초등학교2 {
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int N;
	static Map<Integer, Set<Integer>> student_likes;
	static int[][] grid;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 3~20
		student_likes = new HashMap<>(); // 좋아하는 학생 번호 
		int[] order = new int[N*N]; // 배치해야하는 학생 순서 
		
		// 초기화 
		for(int i=0, size=N*N; i<size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int stu = Integer.parseInt(st.nextToken());
			order[i] = stu;
			student_likes.put(stu, new HashSet<>());
			for(int j=0; j<4; j++) {
				student_likes.get(stu).add(Integer.parseInt(st.nextToken()));
			}
		}
				
		grid = new int[N][N]; // 배치
		int[][] empty = new int[N][N]; // 주변에 빈칸 수 
		
		// 주변 빈칸 수 초기화 
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				for(int d=0; d<4; d++) {
					int nr = r+dir[d][0];
					int nc = c+dir[d][1];
					
					if(nr<0 || nr>=N || nc<0 || nc>=N) continue; 
					
					empty[r][c]++;
				}
			}
		}
	
		for(int i=0, size=N*N; i<size; i++) {
			int student = order[i]; // 배치해야할 학생
			Seat loc_seat = null; // 배치할 자리 
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(grid[r][c] != 0) continue; // 비어있는 칸이 아니면 
					
					Seat cur = new Seat(r, c, getLike(r, c, student), empty[r][c]);
					
					if(loc_seat==null || cur.compareTo(loc_seat)>0) {
						loc_seat = cur;
					}
				}
			}
			
			grid[loc_seat.x][loc_seat.y] = student;
			
			// 놓인 부분 주변 빈칸-1 
			for(int d=0; d<4; d++) {
				int nr = loc_seat.x+dir[d][0];
				int nc = loc_seat.y+dir[d][1];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N) continue; 
				
				empty[nr][nc]--;
			}
		}
		
		int result = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				int cnt = getLike(r, c, grid[r][c]);
				if(cnt > 0) result += Math.pow(10, cnt-1);
			}
		}
		System.out.println(result);
	}
	
	public static class Seat implements Comparable<Seat>{
		int x;
		int y;
		int like; // 주변에 좋아하는 학생 수 
		int empty; // 주변에 빈칸 수 
		
		Seat(int x, int y, int like, int empty){
			this.x = x;
			this.y = y;
			this.like = like; 
			this.empty = empty;
		}
		
		@Override
		public int compareTo(Seat s) {
			// 좋아하는 학생이 인접한 칸에 가장 많은 칸 
			if(this.like != s.like) return this.like - s.like;
			// 인접한 칸 중에서 비어있는 칸이 가장 많은 칸 
			if(this.empty != s.empty) return this.empty - s.empty;
			// 행의 번호가 가장 작은 칸
			if(this.x != s.x) return s.x-this.x;
			// 열의 번호가 가장 작은 칸 
			return s.y-this.y;
		}
	}
	
	public static int getLike(int r, int c, int student) {
		int cnt = 0;
		
		for(int d=0; d<4; d++) {
			int nr = r+dir[d][0];
			int nc = c+dir[d][1];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N) continue; 
			
			if(student_likes.get(student).contains(grid[nr][nc])) {
				cnt++;
			}
		}
		
		return cnt;
	}
}

