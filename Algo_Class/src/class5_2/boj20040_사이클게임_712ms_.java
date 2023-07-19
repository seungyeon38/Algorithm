package class5_2;

import java.util.*;
import java.io.*;

public class boj20040_사이클게임_712ms_ {
	static int[] parents; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int n = Integer.parseInt(st.nextToken()); // 점의 개수 3~500000
		int m = Integer.parseInt(st.nextToken()); // 진행된 차례의 수 3~1000000
		parents = new int[n];
		for(int i=0; i<n; i++) {
			parents[i] = i;
		}
		
		int result = 0;
		// 게임 상황이 주어지고 몇번째 차례에서 사이클이 완성되는지 판단 
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
		
			// 합쳐질 때 
			if(union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))) {
				result = i+1;
				break;
			}
		}
		
		System.out.println(result);
	}
	
	public static boolean union(int n1, int n2) {
		int p_n1 = find(n1);
		int p_n2 = find(n2);
		
		if(p_n1 == p_n2) return true; 
		
		parents[p_n1] = p_n2;
		return false; 
	}
	
	public static int find(int n) {
		if(parents[n] == n) return n; 
		
		return parents[n] = find(parents[n]);
	}
}
