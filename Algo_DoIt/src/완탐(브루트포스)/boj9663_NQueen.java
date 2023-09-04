import java.util.*;
import java.io.*;

public class boj9663_NQueen {
	static int N;
	static int[] queen_place; 
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 15
		queen_place = new int[N];
		
		recur(0);
		
		System.out.println(result);
	}
	
	public static void recur(int r) {
		if(r == N) {
			result++;
			return;
		}
		
		// 놓을 수 있는 곳(c) 탐색
		for(int c=0; c<N; c++) {
			boolean flag = true; 
			
			// 이전 r들 체크 
			for(int i=0; i<r; i++) {
				// 같은 줄에 있으면 안됨 
				if(queen_place[i] == c) {
					flag = false; 
					break;
				}
				// 대각선에 있으면 안됨 
				if(Math.abs(i-r) == Math.abs(queen_place[i]-c)) {
					flag = false; 
					break;
				}
			}
			
			if(flag) {
				queen_place[r] = c;
				recur(r+1);
			}
		}
	}
}
