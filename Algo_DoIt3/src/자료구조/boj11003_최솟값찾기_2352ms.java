package 자료구조;

import java.util.*;
import java.io.*;

public class boj11003_최솟값찾기_2352ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 개수 1~5000000
		int L = Integer.parseInt(st.nextToken()); // 1~5000000
		
		st = new StringTokenizer(br.readLine());
		Deque<Num> deq = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			
			// 뒤에서부터 자기보다 숫자가 작거나 같은 애 pop
			while(deq.peekLast() != null && deq.peekLast().n >= cur) {
				deq.removeLast();
			}
			// 자기 맨 뒤에 넣기 
			deq.add(new Num(i, cur));
			// 앞에서부터 idx 범위 따져서 벗어나는 애 pop
			while(deq.peekFirst() != null && deq.peekFirst().idx <= i-L) {
				deq.removeFirst();
			}
			// 맨 앞에 있는 애 출력 
			sb.append(deq.peek().n).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	public static class Num {
		int idx; 
		int n;
		
		Num(int idx, int n){
			this.idx = idx;
			this.n = n;
		}
	}
}
