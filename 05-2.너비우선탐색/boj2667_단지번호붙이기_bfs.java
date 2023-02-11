package Algorithm;

import java.util.*;
import java.io.*;

public class boj2667_bfs {
	static int[][] arr;
	static boolean[][] visited; 
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 25
		
		StringTokenizer st;
		
		arr = new int[N+2][N+2];
		visited = new boolean[N+2][N+2];
		
		int N_1 = N+1;
		
		for(int i=0; i<=N_1; i++){
			visited[0][i] = true; 
			visited[N_1][i] = true; 
			visited[i][0] = true; 
			visited[i][N_1] = true; 
		}
		
		for(int i=1; i<=N; i++) {
			char[] line = br.readLine().toCharArray();
			
			for(int j=1; j<=N; j++) {
				arr[i][j] = line[j-1]-'0';
			}
		}
		
		int num = 2; 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(arr[i][j] == 1) {
					bfs(num++, new Node(num, i, j));
				}
			}
		}
		
		int[] result = new int[num];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(arr[i][j] == 0) continue;
				result[arr[i][j]]++;
			}
		}
				
		Arrays.sort(result);
				
		StringBuilder sb = new StringBuilder();
		
		sb.append(num-2).append("\n");
		
		for(int i=0; i<num; i++) {
			if(result[i] == 0) continue; 
			sb.append(result[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void bfs(int n, Node node) {
		Queue<Node> queue = new LinkedList();
		
		queue.offer(node);
		visited[node.r][node.c] = true; 
		arr[node.r][node.c] = n;
		
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr = temp.r + dir[d][0];
				int nc = temp.c + dir[d][1];
				
				if(arr[nr][nc]==1 && !visited[nr][nc]) {
					queue.offer(new Node(n, nr, nc));

					visited[nr][nc] = true;
					arr[nr][nc] = n;
				}
			}
		}
	}
	
	public static class Node{
		int n; 
		int r;
		int c;
		
		Node(int n, int r, int c){
			this.n = n; 
			this.r = r;
			this.c = c;
		}
	}
}
