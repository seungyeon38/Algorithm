package day3;

import java.util.*;
import java.io.*;

public class boj13302_리조트_G4_132ms_DP {
	static int N; 
	static boolean[] isNotPossible;
	static int[][] dp; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 쿠폰 3장은 하루 이용권 한 장
		// N일의 여름방학 중 다른 일정으로 리조트에 갈 수 없는 날이 M일 있다
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 1~100 
		int M = Integer.parseInt(st.nextToken()); // 0~N
		
		isNotPossible = new boolean[N+1];
		if(M != 0) st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<M; i++) {
			isNotPossible[Integer.parseInt(st.nextToken())] = true;
		}
		
		// 하루 10000
		// 연속 3일 25000 + 쿠폰1장 
		// 연속 5일 37000 + 쿠폰2장 
		
		// 지불해야하는 최소비용 
		
		// 날짜, 현재 사용비용, 쿠폰 개수 
		// 쿠폰 1일권을 언제 쓸 것인가
		// dp 
		dp = new int[N+1][N+1];
		for(int i=0; i<=N; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		System.out.println(calc(1, 0));
	}
	
	public static int calc(int day, int coupon) {
		if(day > N) return 0;
		
		if(dp[day][coupon] != Integer.MAX_VALUE) return dp[day][coupon];
		
		if(isNotPossible[day]) { 
			dp[day][coupon] = Math.min(dp[day][coupon], calc(day+1, coupon));
		} else {
			if(coupon >= 3) dp[day][coupon] = Math.min(dp[day][coupon], calc(day+1, coupon-3));
			dp[day][coupon] = Math.min(dp[day][coupon], calc(day+1, coupon)+10000);
			dp[day][coupon] = Math.min(dp[day][coupon], calc(day+3, coupon+1)+25000);
			dp[day][coupon] = Math.min(dp[day][coupon], calc(day+5, coupon+2)+37000);
		}
		
		return dp[day][coupon];
	}
}
