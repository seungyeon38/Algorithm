import java.util.*;
import java.io.*;

public class boj14888_연산자끼워넣기 {
	static int N;
	static int[] A;
	static int[] op_cnt;
	static int max; 
	static int min;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 수의 개수 2~11
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken()); // 1~100
		}

		op_cnt = new int[4]; // +, -, *, /
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			op_cnt[i] = Integer.parseInt(st.nextToken());
		}
		
		max = -1000000001;
		min = 1000000001;
		
		calc(1, A[0]);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void calc(int cnt, int val) {
		if(cnt == N) {
			// 계산 
			max = Math.max(max, val);
			min = Math.min(min, val);
			return; 
		}
		
		if(op_cnt[0] > 0) { // +
			op_cnt[0]--;
			calc(cnt+1, val+A[cnt]);
			op_cnt[0]++;
		}
		if(op_cnt[1] > 0) { // -
			op_cnt[1]--;
			calc(cnt+1, val-A[cnt]);
			op_cnt[1]++;
		}
		if(op_cnt[2] > 0) { // *
			op_cnt[2]--;
			calc(cnt+1, val*A[cnt]);
			op_cnt[2]++;
		}
		if(op_cnt[3] > 0) { // /
			op_cnt[3]--;
			calc(cnt+1, val/A[cnt]);
			op_cnt[3]++;
		}
	}
}
