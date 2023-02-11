package Algorithm;

import java.util.*;
import java.io.*;

public class q033_boj1715 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int result = 0;
		
		while(pq.size()>1) {
			int n1 = pq.poll();
			int n2 = pq.poll();
			int sum = n1+n2; 

			result += sum;
			pq.add(sum);
		}
		
		System.out.println(result);
	}
}
