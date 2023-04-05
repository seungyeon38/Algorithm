import java.util.*;
import java.io.*;

public class boj21610_마법사상어와비바라기 {
	static int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
	static ArrayList<int[]> before_cloud; 
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int N = Integer.parseInt(st.nextToken()); // 2~50
		int M = Integer.parseInt(st.nextToken()); // 1~100
		
		int[][] A = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken()); // 0~100
			}
		}
		
		before_cloud = new ArrayList<>();
		ArrayList<int[]> after_cloud = new ArrayList<>();
		
		before_cloud.add(new int[] {N, 1});
		before_cloud.add(new int[] {N, 2});
		before_cloud.add(new int[] {N-1, 1});
		before_cloud.add(new int[] {N-1, 2});
		
		for(int i=0; i<M; i++) { // 이동 
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken())-1; // 방향 1~8
			int s = Integer.parseInt(st.nextToken()); // 이동할 칸 수 1~50 
			
			for(int[] cloud : before_cloud) {
				// 모든 구름 이동 
				cloud[0] += dir[d][0]*s;
				cloud[1] += dir[d][1]*s;
				
				if(cloud[0] > N) cloud[0] %= N;
				while(cloud[0] <= 0) cloud[0] += N;
				if(cloud[1] > N) cloud[1] %= N;
				while(cloud[1] <= 0) cloud[1] += N;
				// 각 구름에서 비가 내려 물의 양이 1 증가 
				A[cloud[0]][cloud[1]]++;
			}
			
			// 물복사버그 마법 
			// 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 바구니 물의 양이 증가 
			// dir[1], dir[3], dir[5], dir[7]
			for(int[] cloud : before_cloud) {
				int cnt = 0;
				for(int j=1; j<=7; j+=2) { // 대각선 방향 					
					int nr = cloud[0]+dir[j][0];
					int nc = cloud[1]+dir[j][1];
					
					if(nr<=0 || nr>N || nc<=0 || nc>N) continue;
					
					if(A[nr][nc] > 0) {
						cnt++;
					}
				}
				
				A[cloud[0]][cloud[1]] += cnt;
			}

			// 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 
			for(int r=1; r<=N; r++) {
				for(int c=1; c<=N; c++) {
					if(A[r][c] > 1 && !contain(r, c)) {
						A[r][c] -= 2;
						after_cloud.add(new int[] {r, c});
					}
				}
			}

			before_cloud = (ArrayList<int[]>) after_cloud.clone();
			after_cloud.clear();
		}
		
		int result = 0;
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=N; c++) {
				result += A[r][c];
			}
		}
		
		System.out.println(result);
	}
	
	public static boolean contain(int r, int c) {
		for(int[] e : before_cloud) {
			if(e[0]==r && e[1]==c) {
				return true; 
			}
		}
		return false; 
	}
}
