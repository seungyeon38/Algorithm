package 구현;

import java.util.*;
import java.io.*;

public class boj1158_요세푸스문제_580ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사람 수 1~5000
		int K = Integer.parseInt(st.nextToken()); // K번째 사람 제거 
		
		Queue<Integer> nums = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			nums.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!nums.isEmpty()) {
			for(int i=1; i<K; i++) {
				int n = nums.poll();
				nums.add(n);
			}
			
			int n = nums.poll();
			sb.append(n).append(", ");
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		
		System.out.println(sb.toString());
	}
}
