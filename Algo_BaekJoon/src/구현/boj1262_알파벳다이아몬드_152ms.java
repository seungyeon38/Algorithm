package 구현;

import java.util.*;
import java.io.*;

public class boj1262_알파벳다이아몬드_152ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1~20000
		int R1 = Integer.parseInt(st.nextToken()); // 0~20000
		int C1 = Integer.parseInt(st.nextToken()); // 0~20000
		int R2 = Integer.parseInt(st.nextToken()); // 0~20000
		int C2 = Integer.parseInt(st.nextToken()); // 0~20000
		
		int term = N*2-1;
		int center = N-1;
		StringBuilder sb = new StringBuilder();
		
		for(int r=R1; r<=R2; r++) {
			for(int c=C1; c<=C2; c++) {
				int cur_r = r%term;
				int cur_c = c%term;
				
				int diff = Math.abs(cur_r-center)+Math.abs(cur_c-center);
				
				if(diff >= N) {
					sb.append(".");
				} else {
					diff %= 26;
					sb.append((char)(diff+'a'));
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
