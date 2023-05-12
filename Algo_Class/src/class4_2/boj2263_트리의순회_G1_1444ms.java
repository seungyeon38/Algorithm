package class4_2;

import java.util.*;
import java.io.*; 

public class boj2263_트리의순회_G1_1956ms {
	static int n; 
	static int[] inorder;
	static int[] postorder;
	static StringBuilder sb; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); // 1~100000
		StringTokenizer st = new StringTokenizer(br.readLine());
		inorder = new int[n];
		for(int i=0; i<n; i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		postorder = new int[n];
		for(int i=0; i<n; i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}
		
		sb = new StringBuilder();
		
		calc(0, n-1, 0, n-1);
		System.out.println(sb.toString());
	}
	
	public static void calc(int in_s, int in_e, int post_s, int post_e) {
		if(in_s == in_e) {
			sb.append(inorder[in_s]).append(" ");
			return; 
		}
		
		// post_e 가 root 
		int root = postorder[post_e];
		sb.append(root).append(" ");
		
		// 인오더에서 root idx 찾기 
		int r_idx = 0;
		for(int i=in_s; i<=in_e; i++) {
			if(root == inorder[i]) {
				r_idx = i;
				break; 
			}
		}
		
		// 왼쪽 개수
		int n = r_idx-in_s;
		
		// 왼
		if(in_s < r_idx) calc(in_s, r_idx-1, post_s, post_s+n-1);
		// 오
		if(r_idx < in_e) calc(r_idx+1, in_e, post_s+n, post_e-1);
	}
}
