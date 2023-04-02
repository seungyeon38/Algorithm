package 자료구조;

import java.util.*;
import java.io.*;

public class q014_boj11286_절댓값힙 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 연산 수 1~100000
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> positive_nums = new PriorityQueue<Integer>();
		PriorityQueue<Integer> negative_nums = new PriorityQueue<Integer>(new Comparator<Integer>(){
			@Override 
			public int compare(Integer n1, Integer n2) {
				return n2-n1;
			}
		});
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine()); 
			
			if(x == 0) { // 연산 
				if(positive_nums.isEmpty()) { // 양수 pq가 빈 경우, 음수 pq에서 꺼내기 
					if(negative_nums.isEmpty()) { // 둘다 빈 경우 
						sb.append("0\n");
					} else {
						sb.append(negative_nums.poll()).append("\n");
					}
				} else if(negative_nums.isEmpty()) { // 음수 pq가 빈 경우, 양수 pq에서 꺼내기 
					sb.append(positive_nums.poll()).append("\n");
				} else { // 둘다 있는 경우, 절댓값 비교 
					if(positive_nums.peek() < Math.abs(negative_nums.peek())) {
						sb.append(positive_nums.poll()).append("\n");
					} else {
						sb.append(negative_nums.poll()).append("\n");
					}
				}
			} else if(x < 0) {
				negative_nums.add(x);
			} else {
				positive_nums.add(x);
			}
		}
		
		System.out.println(sb.toString());
	}
}
