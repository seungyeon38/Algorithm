package Algorithm;

import java.util.*;
import java.io.*;

public class boj1158_요세푸스문제 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue queue = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(queue.size() != 1) {
			for(int i=1; i<K; i++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll()).append(", ");
		}
		
		sb.append(queue.poll()).append(">");
		
		System.out.println(sb.toString());
	}
}
