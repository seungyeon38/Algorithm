package class4;

import java.util.*;
import java.io.*;

public class boj16953_AB {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		Queue<Long> queue = new LinkedList<Long>();
		queue.add(A);
		
		int result = 0; 
		while(!queue.isEmpty()) {
			result++;
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				long cur_num = queue.poll();
				
				if(cur_num == B) {
					System.out.println(result);
					return; 
				}
				
				long calc_n = cur_num*10+1;
				if(calc_n <= B) queue.add(calc_n);
				
				calc_n = cur_num*2;
				if(calc_n <= B) queue.add(calc_n);
			}
		}
		
		System.out.println("-1");
	}
}
