package 자료구조;

import java.util.*;
import java.io.*;

public class boj2164_카드2_192ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 카드 개수 1~500000
		
		Deque<Integer> deq = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			deq.add(i);
		}
		
		while(deq.size() > 1) {
			// 제일 위에 있는 카드 버리기 
			deq.removeFirst();
			// 제일 위에 있는 카드 맨 밑으로 옮기기 
			int n = deq.removeFirst();
			deq.addLast(n);
		}
		
		System.out.println(deq.remove());
	}
}
