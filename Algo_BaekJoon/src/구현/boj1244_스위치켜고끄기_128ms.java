package 구현;

import java.util.*;
import java.io.*;

public class boj1244_스위치켜고끄기_128ms {
	static int N;
	static int[] state;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 스위치 개수 1~100
		state = new int[N+1]; // 스위치 상태
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			state[i] = Integer.parseInt(st.nextToken());
		}
		
		int stu_n = Integer.parseInt(br.readLine()); // 학생 수 1~100
		for(int i=0; i<stu_n; i++) {
			st = new StringTokenizer(br.readLine()); 
			int s = Integer.parseInt(st.nextToken()); // 학생 성별
			int n = Integer.parseInt(st.nextToken()); // 학생이 받은 수 
			
			if(s == 1) calc1(n);
			else if(s == 2) calc2(n);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(state[i]).append(" ");
			if(i%20 == 0) sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void calc1(int n) { // 남학생 
		for(int i=1; i<=N; i++) {
			if(i%n == 0) {
				state[i] = state[i]==0 ? 1 : 0;
			}
		}
	}
	
	public static void calc2(int n) { // 여학생 
		int sp = n-1;
		int ep = n+1;
		state[n] = state[n]==0 ? 1 : 0;
		
		while(sp>0 && ep<=N) {
			if(state[sp] != state[ep]) break; 
			
			state[sp] = state[sp]==0 ? 1 : 0;
			state[ep] = state[sp];
			sp--;
			ep++;
		}
	}
}
