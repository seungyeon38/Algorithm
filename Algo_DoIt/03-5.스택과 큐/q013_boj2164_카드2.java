package Algorithm;

import java.util.*;
import java.io.*;

public class q013_boj2164 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 500000
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		while(queue.size() > 1) {
			queue.poll();
			int n = queue.poll();
			queue.add(n);
		}
		
		System.out.println(queue.poll());
	}
}
