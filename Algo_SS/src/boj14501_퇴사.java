import java.util.*;
import java.io.*;

public class boj14501_퇴사 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~15
		
		Consult[] consult = new Consult[N+1];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			consult[i] = new Consult(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int[] dp = new int[N+2];
		
		for(int i=N; i>0; i--) {
			if(consult[i].time+i <= N+1) {
				dp[i] = Math.max(dp[i+1], consult[i].cost+dp[i+consult[i].time]);
			} else {
				dp[i] = dp[i+1];
			}
		}
		
		System.out.println(dp[1]);
	}
	
	public static class Consult{
		int time; // 1~5 
		int cost; // 1~1000
		
		Consult(int time, int cost) {
			this.time = time; 
			this.cost = cost;
		}
	}
}
