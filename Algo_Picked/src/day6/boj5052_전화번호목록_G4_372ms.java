package day6;

import java.util.*;
import java.io.*;

public class boj5052_전화번호목록_G4_372ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 이 목록이 일관성이 있는지 없는지
		// 전화번호 목록이 일관성을 유지하려면, 한 번호가 다른 번호의 접두어인 경우가 없어야 한다.
		
		int t = Integer.parseInt(br.readLine()); // 1~50
		StringBuilder sb = new StringBuilder(); 
		
		for(int tc=0; tc<t; tc++) {
			Node root = new Node();
			
			int n = Integer.parseInt(br.readLine()); 
			boolean flag = false; 
			for(int i=0; i<n; i++) { // 전화번호 개수 만큼 
				Node now = root; 
				String str = br.readLine();
				if(flag) continue;
				for(int j=0, size=str.length(); j<size; j++) { // 전화번호 글자수 만큼 
					char c = str.charAt(j);
					if(now.next[c-'0'] == null) {
						now.next[c-'0'] = new Node();
					}
					now = now.next[c-'0'];

					if(now.isLast) { // 이 전화번호보다 짧은 일관성없는 전화번호가 있다면 
						flag = true; 
						break;
					}
						
					if(j == str.length()-1) { // 마지막 글자일 경우 
						now.isLast = true; 
						if(now.next[c-'0'] != null) { // 이 다음 글자가 있다면 이것보다 긴 일관성없는 전화번호가 있는 것 
							flag = true; 
						}
					}
				}
			}
			
			if(flag) sb.append("NO").append("\n");
			else sb.append("YES").append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static class Node{
		boolean isLast; 
		Node[] next = new Node[10]; 
	}
}
