package 자료구조;

import java.util.*;
import java.io.*;

public class boj11286_절댓값힙_336ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 연산의 개수 1~100000
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override 
			public int compare(Integer n1, Integer n2) {
				if(Math.abs(n1) == Math.abs(n2)) {
					return n1-n2; 
				}
				return Math.abs(n1) - Math.abs(n2);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine()); // 연산에 대한 정보 
			// 0이 아니면 배열에 x추가 
			// 0이면 배열에서 절댓값이 가장 작은 값 출력 + 제거 
			if(x == 0) {
				if(pq.isEmpty()) sb.append("0\n");
				else sb.append(pq.poll()).append("\n");
			} else {
				pq.add(x);
			}
		}
		
		System.out.println(sb.toString());
	}
}
