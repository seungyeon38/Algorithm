package class4_2;

import java.util.*;
import java.io.*;

public class boj12851_숨바꼭질2_192ms {
	static int N, K;
	static int min = Integer.MAX_VALUE;
	static int count = 0; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 수빈 위치 0~100000
		K = Integer.parseInt(st.nextToken()); // 동생 위치 0~100000
		bfs();
		System.out.println(min);
		System.out.println(count);
	}
	
	public static int bfs() {
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.add(new Pos(N, 0));
		int[] visited = new int[1000001];
		visited[N] = 1; // 해당 위치를 방문할 때 시간 
		
		while(!queue.isEmpty()) {
			Pos cur = queue.poll();
			
			if(cur.t > min) continue; // 시간이 더 크면 할 필요X

			if(cur.pos == K) { // 동생이 있는 자리에 오면 
				if(cur.t < min) { // 최단시간이면  
					min = cur.t; // 최단시간 저장 
					count = 1; // 첫 최단시간이므로 1
				} else if(cur.t == min) { // 현재의 최단시간이면 
					count++; // 개수+1
				} 
				continue; // 더 할 필요X 
			}

			if(cur.pos*2<=100000 && (visited[cur.pos*2]==0 || visited[cur.pos*2] == cur.t+1)) {
				visited[cur.pos*2] = cur.t+1;
				queue.add(new Pos(cur.pos*2, cur.t+1));
			}
			if(cur.pos+1 <= 100000 && (visited[cur.pos+1]==0 || visited[cur.pos+1] == cur.t+1)) {
				visited[cur.pos+1] = cur.t+1;
				queue.add(new Pos(cur.pos+1, cur.t+1));
			}
			if(cur.pos-1 >= 0 && (visited[cur.pos-1]==0 || visited[cur.pos-1] == cur.t+1)) {
				visited[cur.pos-1] = cur.t+1;
				queue.add(new Pos(cur.pos-1, cur.t+1));
			}
		}
		
		return min;
	}
	
	public static class Pos{
		int pos; 
		int t; 
		
		Pos(int pos, int t){
			this.pos = pos; 
			this.t = t;
		}
	}
}
