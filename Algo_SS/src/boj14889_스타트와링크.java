import java.util.*;
import java.io.*;

public class boj14889_스타트와링크 {
	static int N;
	static boolean[] isSelected;
	static int min;
	static int[][] grid;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 4~20 짝수 
		isSelected= new boolean[N];
		min = 20001;
		grid = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		subset(1);
		
		System.out.println(min);
	}
	
	public static void subset(int idx) {
		if(idx == N) { // 부분 집합 
			int cnt = 0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) cnt++;
			}
			if(cnt != N/2) return; 
			
			int sum_start = 0;
			int sum_link = 0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					for(int j=0; j<N; j++) {
						if(isSelected[j]) {
							sum_start += grid[i][j];
						}
					}
				} else {
					for(int j=0; j<N; j++) {
						if(!isSelected[j]) {
							sum_link += grid[i][j];
						}
					}
				}
			}
			min = Math.min(min, Math.abs(sum_start-sum_link));
			
			return;
		}
		
		isSelected[idx] = false; 
		subset(idx+1); // 선택 안했을 때 
		isSelected[idx] = true; 
		subset(idx+1); // 선택 했을 때 
	}
}
