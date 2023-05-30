package class4_2;

import java.util.*;
import java.io.*;

public class boj5639_이진검색트리_336ms {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		list = new ArrayList<Integer>();
		String str;
		while((str = br.readLine()) != null) {
			list.add(Integer.parseInt(str));
		}
		// 전위 순회 루트-왼-오 
		// 후위 순회 왼-오-루트 
		traversal(0, list.size()-1);
		System.out.println(sb.toString());
	}
	
	public static void traversal(int lp, int rp) {
		if(lp > rp) return; 
		
		int mid = lp+1; // 왼쪽 오른쪽 나누기 
		while(mid<=rp && list.get(mid)<list.get(lp)) mid++; 
		
		// mid를 기준으로 왼쪽, 오른쪽이 나뉨 
		traversal(lp+1, mid-1); // 왼쪽 
		traversal(mid, rp); // 오른쪽 
		sb.append(list.get(lp)).append("\n"); // 루트 
	}
}
