package 구현;

import java.util.*;
import java.io.*;

public class boj1316_그룹단어체커_128ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~100
		int result = 0; 
		
		for(int i=0; i<N; i++) {
			char[] str = br.readLine().toCharArray();
			
			boolean[] visited = new boolean['z'-'a'+1];
			boolean isGroup = true; 
			
			for(int j=0; j<str.length; j++) {
				char c = str[j];
				if(visited[c-'a']) {
					isGroup = false; 
					break; 
				}
				
				visited[c-'a'] = true; 
				while(j<str.length-1 && str[j+1] == c) {
					j++;
				}
			}
			
			if(isGroup) result++;
		}
		
		System.out.println(result);
	}
}
