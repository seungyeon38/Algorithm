import java.util.*;
import java.io.*;

public class boj14890_경사로_156ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 지도 길이 2~100
		int L = Integer.parseInt(st.nextToken()); // 경사로 길이 1~N
		
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] routes = new int[2*N][N];
		
		// 가로 길 저장 
		for(int i=0; i<N; i++) {
			routes[i] = map[i];
		}
		
		// 세로 길 저장 
		for(int i=0, n=N; i<N; i++, n++) {
			for(int j=0; j<N; j++) {
				routes[n][j] = map[j][i];
			}
		}
		
		int result = 0;
		for(int i=0, size=2*N; i<size; i++) {
			if(calcPossible(routes[i], L)) result++;
		}
		
		System.out.println(result);
	}
	
	public static boolean calcPossible(int[] route, int L) {
		boolean[] visited = new boolean[route.length]; // 경사로를 놓은 곳 
		
		for(int i=0, size=route.length-1; i<size; i++) {
			if(route[i] == route[i+1]) continue;
			
			int diff = route[i]-route[i+1];
			
			// 높이 차이가 1이 넘는 경우
			if(Math.abs(diff) > 1) return false; 
			
			if(diff == 1) { // 높이가 작아질 경우 
				for(int j=i+1, max=j+L; j<max; j++) {
					// 범위를 벗어나거나, 이미 경사로가 있는 경우 
					if(j>=route.length || visited[j]) return false; 
					// 낮은 지점의 칸의 높이가 L개 연속되지 않은 경우 
					if(route[j] != route[i+1]) return false; 
					visited[j] = true; 
				}
				i += L-1;
			} else if(diff == -1) { // 높이가 커질 경우 
				for(int j=i-L+1; j<=i; j++) {
					// 범위를 벗어나거나, 이미 경사로가 있는 경우 
					if(j<0 || visited[j]) return false; 
					// 낮은 지점의 칸의 높이가 L개 연속되지 않은 경우 
					if(route[j] != route[i]) return false; 
					visited[j] = true; 
				}
			}
		}
		
		return true;
	}
}
