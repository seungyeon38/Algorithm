package class3;

import java.util.*;
import java.io.*;

public class boj1074_Z_분할정복_재귀 {
	static int N, r, c;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 15
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		recur(0, 0, (int)Math.pow(2, N), 0);
	}
	
	public static void recur(int sr, int sc, int n, int cnt) {
		if(sr==r && sc==c) {
			System.out.println(cnt);
			return;
		}

		int n_2 = n/2; 
		int nr = sr+n_2;
		int nc = sc+n_2;
		
		if(r<nr && c<nc) recur(sr, sc, n_2, cnt);
		else if(r<nr && c>=nc) recur(sr, nc, n_2, cnt+n_2*n_2);
		else if(r>=nr && c<nc) recur(nr, sc, n_2, cnt+n_2*n_2*2);
		else recur(nr, nc, n_2, cnt+n_2*n_2*3);
	}	
}
