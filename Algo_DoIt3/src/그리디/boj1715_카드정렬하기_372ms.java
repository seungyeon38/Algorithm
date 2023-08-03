package 그리디;

import java.util.*;
import java.io.*;

public class boj1715_카드정렬하기_372ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~100000
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int result = 0;
		while(pq.size() != 1) {
			int n1 = pq.poll();
			int n2 = pq.poll();
			result += n1+n2;
			pq.add(n1+n2);
		}
		
		System.out.println(result);
	}
}
