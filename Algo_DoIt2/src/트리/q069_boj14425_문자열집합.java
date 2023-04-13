package 트리;

import java.util.*;
import java.io.*;

public class q069_boj14425_문자열집합 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int N = Integer.parseInt(st.nextToken()); // 1~10000
		int M = Integer.parseInt(st.nextToken()); // 1~10000
		
		Node root = new Node();
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			char[] c_arr = str.toCharArray();
			Node cur = root; 
			
			for(int j=0; j<c_arr.length; j++) {
				if(cur.next[c_arr[j]-'a'] == null) {
					cur.next[c_arr[j]-'a'] = new Node();
				} 
				cur = cur.next[c_arr[j]-'a'];
				
				if(j == c_arr.length-1) cur.isLast = true; 
			}
		}
		
		int result = 0;
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			char[] c_arr = str.toCharArray();
			Node cur = root; 

			for(int j=0; j<c_arr.length; j++) {
				if(cur.next[c_arr[j] - 'a'] == null) break; 
				
				cur = cur.next[c_arr[j] - 'a'];
				
				if(j == c_arr.length-1 && cur.isLast) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
	
	public static class Node{
		Node[] next = new Node['z'-'a'+1];
		boolean isLast; 
	}
}
