package day14;

import java.util.*;
import java.io.*;

public class boj9019_DSLR_G4_3784ms {
	static int A, B;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken()); // 0~10000
			B = Integer.parseInt(st.nextToken()); // 0~10000
			
			sb.append(bfs()).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static String bfs() {
		Queue<Num> queue = new LinkedList<Num>();
		queue.add(new Num(A, ""));
		boolean[] visited = new boolean[10000];
		visited[A] = true; 
		
		while(!queue.isEmpty()) {
			Num cur = queue.poll();
			
			if(cur.n == B) return cur.str;
			
			int next = D(cur.n);
			if(!visited[next]) {
				visited[next] = true; 
				queue.add(new Num(next, cur.str+"D"));
			}
			next = S(cur.n);
			if(!visited[next]) {
				visited[next] = true; 
				queue.add(new Num(next, cur.str+"S"));
			}
			next = L(cur.n);
			if(!visited[next]) {
				visited[next] = true; 
				queue.add(new Num(next, cur.str+"L"));
			}
			next = R(cur.n);
			if(!visited[next]) {
				visited[next] = true; 
				queue.add(new Num(next, cur.str+"R"));
			}
		}
		
		return null;
	}
	
	public static class Num{
		int n;
		String str; 
		
		Num(int n, String str){
			this.n = n;
			this.str = str;
		}
	}
	
	public static int D(int n) {
		return n*2%10000;
	}
	
	public static int S(int n) {
		return n == 0 ? 9999 : n-1;
	}
	
	public static int L(int n) {
		int d1 = n/1000;
		n %= 1000;
		int d2 = n/100;
		n %= 100;
		int d3 = n/10;
		n %= 10;
		int d4 = n;
		
		return 1000*d2 + 100*d3 + 10*d4 + d1;
	}
	
	public static int R(int n) {
		int d1 = n/1000;
		n %= 1000;
		int d2 = n/100;
		n %= 100;
		int d3 = n/10;
		n %= 10;
		int d4 = n;
		
		return 1000*d4 + 100*d1 + 10*d2 + d3;
	}
}
