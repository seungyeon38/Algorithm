import java.util.*;
import java.io.*;

public class boj15686_치킨배달_216ms {
	static int N, M;
	static int[][] city;
	static ArrayList<int[]> house_list;
	static ArrayList<int[]> store_list;
	static int store_cnt;
	static boolean[] select; 
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시 크기 2~50
		M = Integer.parseInt(st.nextToken()); // 남길 치킨집 최대 개수 1~13
		city = new int[N][N]; // 도시 정보 (0: 빈칸, 1:집, 2:치킨집)
		house_list = new ArrayList<>();
		store_list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if(city[i][j] == 1) house_list.add(new int[] {i, j});
				else if(city[i][j] == 2) store_list.add(new int[] {i, j});
			}
		}
		
		store_cnt = store_list.size();
		select = new boolean[store_cnt];
		
		// 도시의 치킨 거리가 가장 작게 되도록 
		combi(0, 0);
		System.out.println(result);
	}
	
	public static void combi(int idx, int cnt) { // store_cnt 중에 M개 고르기 
		if(cnt == M) {
			int chicken_distance = getChickenDistance(select);
			result = Math.min(result, chicken_distance);
			
			return; 
		}
		
		for(int i=idx; i<store_cnt; i++) {
			select[i] = true; 
			combi(i+1, cnt+1);
			select[i] = false; 
		}
	}
	
	public static int getChickenDistance(boolean[] select_store) {
		int result = 0;
		
		for(int[] house : house_list) {
			int min_distance = Integer.MAX_VALUE;
			
			for(int i=0; i<store_cnt; i++) {
				if(select_store[i]) {
					min_distance = Math.min(min_distance, getDistance(house, store_list.get(i)));
				}
			}
			
			result += min_distance;
		}
		
		return result;
	}
	
	public static int getDistance(int[] house, int[] store) {
		return Math.abs(house[0]-store[0]) + Math.abs(house[1]-store[1]);
	}
}
