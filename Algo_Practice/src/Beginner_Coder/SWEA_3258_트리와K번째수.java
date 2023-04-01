package Beginner_Coder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_3258_트리와K번째수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<N; i++) {
				graph.add(new ArrayList<Integer>());
			}
			
			int[] weight = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				graph.get(p1).add(p2);
				graph.get(p2).add(p1);
			}
			int result = 0;
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int p1 = Integer.parseInt(st.nextToken()); 
				int p2 = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken()); // 경로상에서 K번째로 작은 가중치
				result += calc(p1, p2, n, weight);
			}
			
			sb.append("#").append(tc).append(" ").append(result);
		}
	}
	
	public static int calc(int p1, int p2, int n, int[] weight) {
		Queue<Integer> queue = new PriorityQueue<Integer>();
		int result = 0;
		
		
		
		for(int i=0; i<n; i++) {
			result = queue.poll();
		}
		return result; 
	}
}
