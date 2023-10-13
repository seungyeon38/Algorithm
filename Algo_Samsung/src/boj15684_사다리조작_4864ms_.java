import java.util.*;
import java.io.*;

public class boj15684_사다리조작_4864ms_ {
	static int N, H;
	static int[][] route;
	static ArrayList<int[]> canDraw;
	static int canDrawSize;	
	static boolean[] select;
	static boolean result = false; 
	static boolean temp_result = false; 

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

		canDraw = new ArrayList<>();
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N-1; j++) {
				if(route[i][j] == 0) {
					canDraw.add(new int[] {i, j});
				}
			}
		}
		
		canDrawSize = canDraw.size();
		
		for(int i=0; i<=3; i++) { // 추가 가로선 개수
			select = new boolean[canDrawSize];
			combi(0, 0, i, select);
			if(result) {
				System.out.println(i);
				return;
			}
		}
		
		if(!result) System.out.println("-1");
	}
	
	public static void combi(int idx, int cnt, int total_cnt, boolean[] select) {
		if(result) return; 
		
		if(cnt == total_cnt) {
			int[][] tempRoute = new int[H][N];
			for(int h=0; h<H; h++) {
				for(int n=0; n<N; n++) {
					tempRoute[h][n] = route[h][n];
				}
			}
			boolean isPossible = true; 
			for(int i=0; i<canDrawSize; i++) {
				if(select[i]) {
					int[] line = canDraw.get(i);
					// 단, 두 가로선이 연속하거나 서로 접하면 안 된다.
					if(!(tempRoute[line[0]][line[1]]==0 && tempRoute[line[0]][line[1]+1]==0)){
						isPossible = false; 
						break;
					} 
					
					tempRoute[line[0]][line[1]] = 1; 
					tempRoute[line[0]][line[1]+1] = 2; 
				}
			}

			// 모든 i번 세로선의 결과가 i번이 나오는지 계산 
			if(isPossible) result = calc(tempRoute);
			
			return; 
		}
		
		for(int i=idx; i<canDrawSize; i++) {
			select[i] = true; 
			combi(i+1, cnt+1, total_cnt, select);
			select[i] = false; 
		}
	}
	
	public static boolean calc(int[][] route) {
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
