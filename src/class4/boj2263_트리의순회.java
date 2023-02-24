package class4;

import java.util.*;
import java.io.*;

public class boj2263_트리의순회 {
	static int n;
	static int[] in, post, pre; 
	static StringBuilder sb; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); // 1~100000
		in = new int[n];
		post = new int[n];
		pre = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			in[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			post[i] = Integer.parseInt(st.nextToken());
		}
		
		sb = new StringBuilder(); 
		
		findPre(0, n-1, 0, n-1); 
		
		System.out.println(sb.toString());
	}
	
	public static void findPre(int is, int ie, int ps, int pe) {
		if(is > ie) return;  
		
		if(ps == pe) {
			sb.append(post[ps]).append(" ");
			return; 
		}
		
		int root = post[pe];
		int in_root_idx = -1; // 이걸 기준으로 왼쪽 오른쪽 
		
		for(int i=is; i<=ie; i++) {
			if(in[i] == root) {
				in_root_idx = i;
				break; 
			}
		}
		
		sb.append(root).append(" ");
		findPre(is, in_root_idx-1, ps, ps+in_root_idx-is-1);
		findPre(in_root_idx+1, ie, ps+in_root_idx-is, pe-1); 
	}
}
