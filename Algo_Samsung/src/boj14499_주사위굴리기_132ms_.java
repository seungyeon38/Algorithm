import java.util.*;
import java.io.*;

public class boj14499_주사위굴리기_132ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 지도 세로 크기 1~20
		int M = Integer.parseInt(st.nextToken()); // 지도 가로 크기 1~20
		int x = Integer.parseInt(st.nextToken()); // 주사위 x좌표 
		int y = Integer.parseInt(st.nextToken()); // 주사위 y좌표
		int K = Integer.parseInt(st.nextToken()); // 명령 개수 1~1000
		int[][] map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dice = new int[6];
		int cur_x = x; // 현재 주사위 위치 
		int cur_y = y;
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		// 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사
		// 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사, 칸에 쓰여 있는 수는 0이 됨
		// 이동할 때마다 주사위의 윗 면에 쓰여 있는 수를 출력
		for(int i=0; i<K; i++) {
			int order = Integer.parseInt(st.nextToken());
			
			int next_x = cur_x;
			int next_y = cur_y;
			
			switch(order) {
			case 1: // 동 
				next_y++;
				break;
			case 2: // 서
				next_y--;
				break;
			case 3: // 북
				next_x--;
				break;
			case 4: // 남 
				next_x++;
				break;
			}
			
			if(next_x<0 || next_x>=N || next_y<0 || next_y>=M) continue; 
			
			cur_x = next_x;
			cur_y = next_y;

			roll(dice, order);

			if(map[cur_x][cur_y] == 0) {
				map[cur_x][cur_y] = dice[5];
			} else {
				dice[5] = map[cur_x][cur_y];
				map[cur_x][cur_y] = 0;
			}
			sb.append(dice[0]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void roll(int[] dice, int d) {
		switch(d) {
		case 1: // 동 
			int temp = dice[3];
			dice[3] = dice[0];
			dice[0] = dice[2];
			dice[2] = dice[5];
			dice[5] = temp;
			break;
		case 2: // 서 
			temp = dice[2];
			dice[2] = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[5];
			dice[5] = temp;
			break;
		case 3: // 북 
			temp = dice[5];
			dice[5] = dice[4];
			dice[4] = dice[0];
			dice[0] = dice[1];
			dice[1] = temp;
			break;
		case 4: // 남 
			temp = dice[1];
			dice[1] = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = temp;
			break;
		}
	}
}
