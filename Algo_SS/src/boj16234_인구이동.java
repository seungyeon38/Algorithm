import java.util.*;
import java.io.*;

public class boj16234_인구이동 {
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int N,L,R;
	static int[][] A;
	static boolean[][] visited;
	static boolean flag;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 1~50
		L = Integer.parseInt(st.nextToken()); // 1~100
		R = Integer.parseInt(st.nextToken()); // 1~100
		
		A = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		flag = true; 
		visited = new boolean[N][N];
		
		while(flag) {
			flag = false; 
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {
						move(i, j); // 국경 열고 인구 이동
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				Arrays.fill(visited[i], false);
			}
			
			if(flag) result++; // 위의 과정에서 국경을 여는 경우가 있었다면 
		}
		
		System.out.println(result);
	}
	
	public static void move(int r, int c) {
		ArrayList<int[]> list = new ArrayList<int[]>();
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {r, c});
		list.add(new int[] {r, c});
		visited[r][c] = true;
		
		int sum = A[r][c]; // 인구 
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = cur[0] + dir[i][0];
				int nc = cur[1] + dir[i][1];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
				
				if(!visited[nr][nc] && open(cur[0], cur[1], nr, nc)) { // 국경을 열 수 있으면 
					visited[nr][nc] = true;		
					list.add(new int[] {nr, nc});
					queue.add(new int[] {nr, nc});
					sum += A[nr][nc];
					flag = true; // 국경을 여는 경우가 있으면 
				}
			}
		}
		
		// 인구수 업데이트 
		if(flag) {
			int aver = sum/list.size();
			
			for(int[] p : list) {
				A[p[0]][p[1]] = aver;
			}
		}
	}
	
	public static boolean open(int r1, int c1, int r2, int c2) {
		int diff = Math.abs(A[r1][c1]-A[r2][c2]);
		
		return diff>=L && diff<=R ? true : false;
	}
}
