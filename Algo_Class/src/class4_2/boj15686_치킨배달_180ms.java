package class4_2;

import java.util.*;
import java.io.*;

public class boj15686_치킨배달_180ms {
	static int N, M; 
	static ArrayList<int[]> stores, houses; 
	static int store_cnt;
	static boolean[] visited; 
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 2~50 
		M = Integer.parseInt(st.nextToken()); // 폐업시키지 않을 치킨집 1~13
		
		int[][] grid = new int[N][N]; // 0:빈칸, 1:집, 2:치킨집 
		stores = new ArrayList<int[]>();
		houses = new ArrayList<int[]>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if(grid[i][j] == 2) {
					stores.add(new int[] {i, j});
					store_cnt++;
				} else if(grid[i][j] == 1) {
					houses.add(new int[] {i, j});
				}
			}
		}
		
		visited = new boolean[store_cnt];
		
		comb(0, 0);
		System.out.println(min);
	}
	
	public static void comb(int cnt, int s) { // 조합 
		if(cnt == M) {			
			// 각각의 집에 대해서 가장 가까운 치킨 거리 구해서 더하기 
			int temp = 0;
			for(int i=0; i<houses.size(); i++) {
				temp += calcChickDistance(houses.get(i));
			}
			min = Math.min(min, temp);
			
			return; 
		}
		
		for(int i=s; i<store_cnt; i++) {
			if(visited[i]) continue; 
			
			visited[i] = true; 
			comb(cnt+1, i+1);
			visited[i] = false; 
		}
	}
	
	// 해당 집에 대해서 치킨 거리 구하기 
	public static int calcChickDistance(int[] home) {
		int min = Integer.MAX_VALUE;
		for(int i=0; i<store_cnt; i++) {
			if(visited[i]) {
				int d = calcDistance(stores.get(i)[0], stores.get(i)[1], home[0], home[1]);
				min = Math.min(min, d);
			}
		}
		
		return min;
	}
	
	
	public static int calcDistance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1-r2)+Math.abs(c1-c2);
	}
}
