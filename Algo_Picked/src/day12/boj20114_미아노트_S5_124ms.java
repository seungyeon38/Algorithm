package day12;

import java.util.*;
import java.io.*; 

public class boj20114_미아노트_S5_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 문자열의 길이 1~100
		int H = Integer.parseInt(st.nextToken()); // 세로로 번진 글자의 개수 1~10 
		int W = Integer.parseInt(st.nextToken()); // 가로로 번진 글자의 개수 1~10 
		
		char[] str = new char[N*W];
		Arrays.fill(str, '?');
		
		for(int i=0; i<H; i++) {
			char[] cur = br.readLine().toCharArray();
			
			for(int j=0, size=N*W; j<size; j++) {
				if(str[j] == '?' && cur[j] != '?') {
					str[j] = cur[j];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			boolean find = false; 
			for(int s=i*W, j=0; j<W; s++, j++) {
				if(str[s] != '?') {
					find = true; 
					sb.append(str[s]);
				}
				if(find) break; 
			}
			if(!find) sb.append("?");
		}
		
		System.out.println(sb.toString());
	}
}
