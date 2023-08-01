package Practice;

import java.util.*;
import java.io.*; 

public class boj10815_숫자카드_944ms_Map {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자 카드 개수 1~500000
		Map<String, Integer> nums = new HashMap<String, Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums.put(st.nextToken(), 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder(); 
		for(int i=0; i<M; i++) {
			if(nums.get(st.nextToken()) != null) sb.append("1 ");
			else sb.append("0 ");
		}
		
		System.out.println(sb.toString());
	}
}
