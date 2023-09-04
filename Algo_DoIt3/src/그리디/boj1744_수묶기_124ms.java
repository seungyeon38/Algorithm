package 그리디;

import java.util.*;
import java.io.*;

public class boj1744_수묶기_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 수열의 크기 1~50
		PriorityQueue<Integer> positive_nums = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> negative_nums = new PriorityQueue<Integer>();

		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num > 0) { // 양수 
				positive_nums.add(num);
			} else { // 음수 
				negative_nums.add(num);
			}
		}

		// 두 수 묶기 가능 
		// 합 최대 
		int result = 0; 
		while(positive_nums.size()>1) {
			int n1 = positive_nums.poll();
			int n2 = positive_nums.poll();
			
			if(n1==1 || n2==1) {
				positive_nums.add(n1);
				positive_nums.add(n2);
				break;
			}
			result += n1*n2;
		}
		
		while(!positive_nums.isEmpty()) {
			result += positive_nums.poll();
		}
		
		while(negative_nums.size() > 1) {
			int n1 = negative_nums.poll();
			int n2 = negative_nums.poll();
			
			result += n1*n2;
		}
		
		while(!negative_nums.isEmpty()) {
			result += negative_nums.poll();
		}
		
		System.out.println(result);
	}
}
