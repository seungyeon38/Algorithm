import java.util.*;
import java.io.*;

public class boj15684_사다리조작_316ms_ {
	static int N, H;
	static int[][] route;
	static boolean result = false; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로선 개수 2~10
		int M = Integer.parseInt(st.nextToken()); // 가로선 개수 
		H = Integer.parseInt(st.nextToken()); // 세로선마다 가로선을 놓을 수 있는 위치의 개수 1~30 
		route = new int[H][N];
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			route[a][b] = 1; // 1: 오른쪽, 2: 왼쪽 
			route[a][b+1] = 2;
		}
		
		for(int i=0; i<=3; i++) { // 추가 가로선 개수
			dfs(0, 0, i);
			if(result) {
				System.out.println(i);
				return;
			}
		}
		
		if(!result) System.out.println("-1");
	}
	
	public static void dfs(int cur_h, int cnt, int total_cnt) {
		if(result) return; 
		
		if(cnt == total_cnt) {
			// 모든 i번 세로선의 결과가 i번이 나오는지 계산 
			if(calc()) {
				result = true; 
			}
			
			return; 
		}

		for(int h=cur_h; h<H; h++) {
			for(int n=0; n<N-1; n++) {
				if(route[h][n]==0 && route[h][n+1]==0) {
					route[h][n] = 1;
					route[h][n+1] = 2;
					dfs(h, cnt+1, total_cnt);
					route[h][n] = 0;
					route[h][n+1] = 0;
				}
			}
		}
	}
	
	public static boolean calc() {
		for(int i=0; i<N; i++) { // i에서 시작해서 i로 가야함
			int n = i;
			
			for(int j=0; j<H; j++) {
				if(route[j][n] == 1) n++;
				else if(route[j][n] == 2) n--;
			}
			
			if(n != i) return false; 
		}
		
		return true; 
	}
}
