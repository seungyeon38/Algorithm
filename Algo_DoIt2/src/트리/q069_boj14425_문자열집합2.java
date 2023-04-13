package 트리;

import java.util.*;
import java.io.*;

public class q069_boj14425_문자열집합2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int N = Integer.parseInt(st.nextToken()); // 1~10000
		int M = Integer.parseInt(st.nextToken()); // 1~10000
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0; i<N; i++) {
			map.put(br.readLine(), 0);
		}
		
		int result = 0; 
		for(int i=0; i<M; i++) {
			if(map.containsKey(br.readLine())) {
				result++;
			}
		}
		
		System.out.println(result);
	}
}
