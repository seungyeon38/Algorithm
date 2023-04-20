package day5;

import java.util.*;
import java.io.*;

public class boj9079_동전게임_S2_120ms {
	static int[][] grid; 
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		게임의 목적은 이 동전의 모양을 모두 같은 면(H나 T)이 보이도록 하는 것
//		한 행의 모든 동전, 한 열의 모든 동전 또는 하나의 대각선 상의 모든 동전을 한 번에 뒤집어야 한다.
//		최소 횟수의 연산으로 실행하고 싶어한다.
//		불가능한 모양이 있다
		
		int T = Integer.parseInt(br.readLine()); // 1~10
		grid = new int[3][3];
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			visited = new boolean[512];

			for(int r=0; r<3; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<3; c++) {
					if(st.nextToken().charAt(0) == 'H') {
						grid[r][c] = 1;
					} else {
						grid[r][c] = 0;
					}
				}
			}
			
			sb.append(bfs()).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int matrixToInt() {
		int result = 0;
		for(int r=2; r>=0; r--) {
			for(int c=2; c>=0; c--) {
				result = result*2 + grid[r][c];
			}
		}
		
		return result;
	}
	
	public static void intToMatrix(int n){
		for(int r=0; r<3; r++) {
			for(int c=0; c<3; c++) {
				grid[r][c] = n%2;
				n/=2; 
			}
		}
	}
	
	public static boolean allSame() {
		int c = grid[0][0];
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(c != grid[i][j]) {
					return false; 
				}
			}
		}
		
		return true ;
	}
	
	public static void flipColumn(int idx) {
		for(int r=0; r<3; r++) {
			grid[r][idx] = (grid[r][idx]+1)%2;
		}
	}
	
	public static void flipRow(int idx) {
		for(int c=0; c<3; c++) {
			grid[idx][c] = (grid[idx][c]+1)%2;
		}
	}
	
	public static void flipCross(int idx) {
		if(idx == 0) {
			for(int r=0; r<3; r++) {
				grid[r][2-r] = (grid[r][2-r]+1)%2;
			}
		} else if(idx == 1) {
			for(int r=0; r<3; r++) {
				grid[r][r] = (grid[r][r]+1)%2;
			}
		}
	}
	
	public static int bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		int s = matrixToInt();
		q.add(new int[] {s, 0});
		visited[s] = true; 
		
		while(!q.isEmpty()) {
			int[] cur = q.poll(); // 매트리스, 뒤집은 횟수 
			
			intToMatrix(cur[0]); // 현재 상태로 변경 
			if(allSame()) { // 다 같으면 
				return cur[1];
			}
			
			for(int r=0; r<3; r++) {
				flipRow(r);
				int next = matrixToInt();
				if(!visited[next]) {
					visited[next] = true; 
					q.add(new int[] {next, cur[1]+1});
				}
				flipRow(r);
			}
			
			for(int c=0; c<3; c++) {
				flipColumn(c);
				int next = matrixToInt();
				if(!visited[next]) {
					visited[next] = true; 
					q.add(new int[] {next, cur[1]+1});
				}
				flipColumn(c);
			}
			
			for(int d=0; d<2; d++) {
				flipCross(d);
				int next = matrixToInt();
				if(!visited[next]) {
					visited[next] = true; 
					q.add(new int[] {next, cur[1]+1});
				}
				flipCross(d);
			}
		}
		
		return -1;
	}
}
