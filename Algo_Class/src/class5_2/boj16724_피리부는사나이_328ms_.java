package class5_2;

import java.util.*;
import java.io.*;

public class boj16724_피리부는사나이_328ms_ {
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //  U,D,L,R
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static boolean[][] finished; 
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 1~1000
		M = Integer.parseInt(st.nextToken()); // 1~1000
		
		map = new char[N][M]; // 지도의 정보 
		// 회원들이 지도 어느 구역에 있더라도 성우가 피리를 불 때 SAFE ZONE에 들어갈 수 있게 하는 SAFE ZONE의 최소 개수 
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 그 그룹 내에서 하나 
		// 그룹 개수 세기 
		visited = new boolean[N][M]; // 방문 유무 
		finished = new boolean[N][M]; // 사이클 확인 유무 
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visited[i][j]) continue; 
				dfs(i, j);
			}
		}
		
		System.out.println(result);
	}
	
	public static void dfs(int r, int c) {
		visited[r][c] = true; 
	
		int nr = -1;
		int nc = -1; 
	
		switch(map[r][c]){
		case 'U':
			nr = r+dir[0][0];
			nc = c+dir[0][1];
			break; 
		case 'D':
			nr = r+dir[1][0];
			nc = c+dir[1][1];
			break;
		case 'L':
			nr = r+dir[2][0];
			nc = c+dir[2][1];
			break; 
		case 'R':
			nr = r+dir[3][0]; 
			nc = c+dir[3][1];
			break;
		}
		
		if(!visited[nr][nc]) { // 방문하지 않은 곳이면 
			dfs(nr, nc);
		} else { // 사이클 생김 
			if(!finished[nr][nc]) result++; // 사이클 만드는데에 쓰이지 않은 곳이라면 
		}
		
		finished[r][c] = true; // 다 끝난 후에 체크 
	}
}
