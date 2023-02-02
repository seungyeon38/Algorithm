package Algorithm;

import java.util.*;
import java.io.*;

public class q053_boj2252 {
	static ArrayList<Integer>[] list; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 32000
		int M = Integer.parseInt(st.nextToken()); // 100000
		
		list = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		int[] degree_arr = new int[N+1]; // 진입 
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			list[n1].add(n2);
			degree_arr[n2]++;
		}
		
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			if(degree_arr[i] == 0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			
			sb.append(num).append(" ");
			
			for(int temp : list[num]) {
				degree_arr[temp]--;
				if(degree_arr[temp] == 0) {
					queue.offer(temp);
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
