import java.util.*;
import java.io.*;

public class boj15686_치킨배달 {
	static int N, M;
	static ArrayList<int[]> house_list;
	static ArrayList<int[]> chicken_list;
	static boolean[] isSelected;
	static int sum;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시 수 2~50
		M = Integer.parseInt(st.nextToken()); // 치킨 집 1~13
		
		house_list = new ArrayList<int[]>();
		chicken_list = new ArrayList<int[]>();

		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 1) {
					house_list.add(new int[] {i, j});
				} else if(n == 2) {
					chicken_list.add(new int[] {i, j});
				}
			}
		}
		
		isSelected = new boolean[chicken_list.size()];
		sum = 10001;
		calc(0, 0);
		
		System.out.println(sum);
	}
	
	public static void calc(int s, int n) {
		// 치킨집 M개 고르기 
		if(n == M) {
			// 거리 계산 
			// 집-치킨집 
			int temp_sum = 0; 
			for(int i=0; i<house_list.size(); i++) { // 집마다 
				int temp_min = 101;
				for(int j=0; j<chicken_list.size(); j++){ // 가장 가까운 치킨집까지의 거리 구하기 
					if(isSelected[j]) {
						temp_min = Math.min(temp_min, getDist(chicken_list.get(j), house_list.get(i)));
					}
				}
				temp_sum += temp_min;
			}
			
			sum = Math.min(sum, temp_sum);
			
			return; 
		}
		
		for(int i=s; i<chicken_list.size(); i++) {
			isSelected[i] = true; 
			calc(i+1, n+1);
			isSelected[i] = false;
		}
	}
	
	public static int getDist(int[] d1, int[] d2) {
		return Math.abs(d1[0]-d2[0])+Math.abs(d1[1]-d2[1]);
	}
}
