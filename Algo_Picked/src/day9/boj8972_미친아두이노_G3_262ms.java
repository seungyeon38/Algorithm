package day9;

import java.util.*;
import java.io.*;

public class boj8972_미친아두이노_G3_262ms {
	static int[][] dir = {{}, {1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 0}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
	static int R, C; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 1~100
		C = Integer.parseInt(st.nextToken()); // 1~100
		
		// '.'는 빈 칸, 'R'은 미친 아두이노, 'I'는 종수의 위치
		char[][] board = new char[R][C];
		int[][] crazy_cnt = new int[R][C];
		int[] jongsu = new int[2];
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				board[i][j] = str.charAt(j);
				if(board[i][j] == 'R') crazy_cnt[i][j]++;
				else if(board[i][j] == 'I') jongsu = new int[] {i, j};
			}
		}
		
		String str = br.readLine();
		int[] move_dir = new int[str.length()]; // 종수가 움직이려는 방향 1~100 
		for(int i=0, size=str.length(); i<size; i++) {
			move_dir[i] = str.charAt(i)-'0';
		}
		
		// 1. 종수가 아두이노를 8가지 방향(수직,수평,대각선)으로 이동시키거나, 그 위치에 그대로 놔둔다.
		// 2. 종수의 아두이노가 미친 아두이노가 있는 칸으로 이동한 경우에는 게임이 끝나게 되며, 종수는 게임을 지게 된다.
		// 3. 미친 아두이노는 8가지 방향 중에서 종수의 아두이노와 가장 가까워 지는 방향으로 한 칸 이동한다. (|r1-r2| + |s1-s2|가 가장 작아지는 방향)
		// 4. 미친 아두이노가 종수의 아두이노가 있는 칸으로 이동한 경우에는 게임이 끝나게 되고, 종수는 게임을 지게 된다.
		// 5. 2개 또는 그 이상의 미친 아두이노가 같은 칸에 있는 경우에는 큰 폭발이 일어나고, 그 칸에 있는 아두이노는 모두 파괴된다.
		
		for(int i=0; i<move_dir.length; i++) {
			// 종수 이동 
			board[jongsu[0]][jongsu[1]] = '.';
			jongsu[0] += dir[move_dir[i]][0];
			jongsu[1] += dir[move_dir[i]][1];
			
			// 종수의 아두이노가 미친 아두이노가 있는 칸으로 이동한 경우, 게임 끝 
			if(board[jongsu[0]][jongsu[1]] == 'R') { 
				System.out.println("kraj "+(i+1));
				return;
			}
			
			board[jongsu[0]][jongsu[1]] = 'I';
			char[][] move_board = new char[R][C];
			
			// 미친 아두이노 이동 
			// 복붙 
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					move_board[r][c] = board[r][c];
				}
			}
			
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(board[r][c] == 'R') {
						int c_dir = getDir(r, c, jongsu[0], jongsu[1]); //  미친 아두이노가 이동할 방향 

						if(crazy_cnt[r][c] == 1) move_board[r][c] = '.';
						crazy_cnt[r][c]--;
						int nr = r + dir[c_dir][0];
						int nc = c + dir[c_dir][1];
												
						// 종수의 아두이노가 있는 칸으로 이동한 경우, 게임 끝
						if(board[nr][nc] == 'I') {
							System.out.println("kraj "+(i+1));
							return;
						}
						crazy_cnt[nr][nc]++;
						move_board[nr][nc] = 'R';
					}
				}
			}
			
			// 2개 또는 그 이상의 미친 아두이노가 같은 칸에 있는 경우, 폭발, 아두이노 파괴 
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(crazy_cnt[r][c] >= 2) { 
						move_board[r][c] = '.';
						crazy_cnt[r][c] = 0;
					} 
				}
			}
			
			// 옮기기 
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					board[r][c] = move_board[r][c];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	// 미친 아두이노가 움직일 방향 
	public static int getDir(int cr, int cc, int jr, int jc) {
		int min = Integer.MAX_VALUE;
		int min_dir = -1; 
		
		for(int d=1; d<=9; d++) {
			if(d == 5) continue; 
			
			int nr = cr + dir[d][0];
			int nc = cc + dir[d][1];
			if(nr<0 || nr>=R || nc<0 || nc>=C) continue; 
			
			int dist = Math.abs(nr-jr)+Math.abs(nc-jc);
			if(dist < min) {
				min = dist; 
				min_dir = d;
			}
		}
		
		return min_dir;
	}
}
