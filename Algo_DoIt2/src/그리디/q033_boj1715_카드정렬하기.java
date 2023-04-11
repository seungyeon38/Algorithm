package 그리디;

import java.util.*;
import java.io.*;

public class q033_boj1715_카드정렬하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 카드 묶음 수 1~100000
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		
		for(int i=0; i<N; i++) {
			pq.add(Long.parseLong(br.readLine())); // 1000
		}
		
		long result = 0; 
		
		while(pq.size() > 1) {
			long n1 = pq.poll();
			long n2 = pq.poll();
			long sum = n1+n2; 
			result += sum;
			pq.add(sum);
		}
		
		System.out.println(result);
	}
}
