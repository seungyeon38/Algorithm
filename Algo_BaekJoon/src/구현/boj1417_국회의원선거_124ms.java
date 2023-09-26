package 구현;

import java.util.*;
import java.io.*;

public class boj1417_국회의원선거_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 후보수 1~49

		if(N == 1) {
			System.out.println("0");
			return;
		}
		
		int dasom_cnt = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> vote_cnt = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=1; i<N; i++) {
			vote_cnt.add(Integer.parseInt(br.readLine()));
		}
		
		int result = 0;

		while(vote_cnt.peek() >= dasom_cnt) {
			dasom_cnt++;
			result++;
			vote_cnt.add(vote_cnt.poll()-1);
		}
		
		System.out.println(result);
	}
}
