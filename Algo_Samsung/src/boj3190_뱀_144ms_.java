import java.util.*;
import java.io.*;

public class boj3190_뱀_144ms_ {
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상, 우, 하, 좌
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 사과를 먹으면 뱀 길이가 늘어남 
		// 벽 또는 자기자신의 몸과 부딪히면 게임이 끝남 
		// 맨위 맨좌측에서 시작, 뱀 길이 1, 처음에 오른쪽 방향 
		
		int N = Integer.parseInt(br.readLine()); // 보드의 크기 2~100
		int K = Integer.parseInt(br.readLine()); // 사과의 개수 0~100
		int cur_d = 1;
		int[] head = new int[2]; // 뱀 머리 좌표
		
		int[][] board = new int[N][N]; // 아무것도 없으면: 0
		for(int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1; // 사과: 1
		}
		
		board[0][0] = 2; // 뱀: 2
		ArrayList<int[]> snake = new ArrayList<>();
		snake.add(new int[] {0, 0});
		
		int L = Integer.parseInt(br.readLine()); // 방향 변환 횟수 1~100
		int t = 0;
		
		Map<Integer, Character> dir_map = new HashMap<>();
		
		for(int i=0; i<L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dir_map.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
		}
		
		while(true) { // X초 동안 이동 
			t++;
			int nx = head[0]+dir[cur_d][0];
			int ny = head[1]+dir[cur_d][1];
			
			// 게임 끝나는 경우 2가지 
			// 벽에 부딪힌 경우 
			if(nx<0 || nx>=N || ny<0 || ny>=N) {
				break; 
			}
			// 뱀인 경우 
			if(crash(nx, ny, snake)) {
				break;
			}
			
			// 사과인 경우 
			if(board[nx][ny] == 1) {
				board[nx][ny] = 0; // 사과 없어짐 
				head[0] = nx; // 머리만 이동 
				head[1] = ny;
				board[nx][ny] = 2;
				snake.add(new int[] {nx, ny});
			} else { // 아무것도 없는 경우 
				// 머리 이동 
				head[0] = nx; 
				head[1] = ny;
				board[nx][ny] = 2;
				snake.add(new int[] {nx, ny});
				// 꼬리 이동 
				snake.remove(0);
			}
			
			// 방향 전환 
			if(dir_map.containsKey(t)) {
				char c = dir_map.get(t);
				if(c == 'D') {
					cur_d++;
					if(cur_d == 4) cur_d = 0;
				} else {
					cur_d--;
					if(cur_d == -1) cur_d = 3;
				}
			}
		}
		
		System.out.println(t);
	}
	
	public static boolean crash(int x, int y, ArrayList<int[]> snake) {
		for(int[] loc : snake) {
			if(x==loc[0] && y==loc[1]) {
				return true;
			}
		}
		
		return false; 
	}
}
