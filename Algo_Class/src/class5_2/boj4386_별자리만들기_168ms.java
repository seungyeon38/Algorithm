package class5_2;

import java.util.*;
import java.io.*;

public class boj4386_별자리만들기_168ms {
	static int[] parents;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 별의 개수 1~100
		double[][] stars = new double[n][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			stars[i][0] = Double.parseDouble(st.nextToken()); // 0~1000
			stars[i][1] = Double.parseDouble(st.nextToken());
		}
		
		// 별자리를 만드는 최소 비용 구하기 
		// 선을 하나 이을 때마다 두 별 사이의 거리만큼 비용이 듦
		// 사이클 
		PriorityQueue<Line> pq = new PriorityQueue<Line>();
		
		// 두 별 사이의 거리 계산 
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) { 
				double distance = getDistance(stars[i], stars[j]);
				pq.add(new Line(i, j, distance));
				pq.add(new Line(j, i, distance));
			}
		}

		parents = new int[n];
		for(int i=0; i<n; i++) {
			parents[i] = i;
		}
		
		double result = 0;
		while(!pq.isEmpty()) {
			Line line = pq.poll();
			
			if(find(line.sp) == find(line.ep)) continue; 
			
			result += line.distance;
			union(line.sp, line.ep);
		}
		
		System.out.printf("%.2f", result);
	}
	
	public static class Line implements Comparable<Line>{
		int sp; 
		int ep; 
		double distance; 
		
		Line(int sp, int ep, double distance){
			this.sp = sp;
			this.ep = ep; 
			this.distance = distance;
		}
		
		@Override 
		public int compareTo(Line l) {
			if(this.distance<l.distance) return -1;
			else return 1;
		}
	}
	
	public static void union(int n1, int n2) {
		int n1_p = find(n1);
		int n2_p = find(n2);
		
		if(n1_p == n2_p) return;
		
		parents[n1_p] = n2_p;
	}
	
	public static int find(int n) {
		if(parents[n] == n) return n;
		
		return parents[n] = find(parents[n]);
	}
	
	public static double getDistance(double[] p1, double[] p2) {
		return Math.sqrt(Math.pow(p2[0]-p1[0], 2)+Math.pow(p2[1]-p1[1], 2));
	}
}
