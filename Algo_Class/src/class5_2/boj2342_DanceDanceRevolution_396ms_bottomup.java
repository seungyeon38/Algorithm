package class5_2;

import java.util.*;
import java.io.*;

public class boj2342_DanceDanceRevolution_396ms_bottomup {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> order = new ArrayList<Integer>(); // 지시 사항 
		int temp = Integer.parseInt(st.nextToken());
		while(temp != 0) {
			order.add(temp);
			temp = Integer.parseInt(st.nextToken());
		}
		
		int order_n = order.size();
		int[][][] dp = new int[5][5][order_n+1]; // 왼쪽, 오른쪽, 단계 
		int INF = 1000000;
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				for(int k=0; k<=order_n; k++) {
					dp[i][j][k] = INF;
				}
			}
		}
		
		dp[0][0][0] = 0;
		
		// 두 발이 같은 지점에 있을 수 X 

		
		
		for(int i=1; i<=order_n; i++) {
			int move = order.get(i-1); // 여기로 가고 싶음 
			
			for(int l=0; l<5; l++){
				for(int r=0; r<5; r++) {
					int before = dp[l][r][i-1]; // 이전거 
					if(before == INF) continue; 
					
					// 오른쪽이 이동 
					if(move != l) dp[l][move][i] = Math.min(dp[l][move][i], before+calc(r, move));
					// 왼쪽이 이동
					if(move != r) dp[move][r][i] = Math.min(dp[move][r][i], before+calc(l, move));
				}
			}
		}
		
		int result = INF;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				result = Math.min(result, dp[i][j][order_n]);
			}
		}
		
		System.out.println(result);
	}
	
	// 같은 지점 : 1
	// 중앙 -> 다른 지점 : 2
	// 다른 지점 -> 인접한 지점 : 3
	// 반대편 지점 : 4
	// 중심 0 위 1 왼 2 아래 3 오 4
	public static int calc(int cur, int next) {
		if(cur == next) return 1;
		else if(cur == 0) return 2;
		else if(Math.abs(cur-next) == 2) return 4;
		else return 3;
	}
}
