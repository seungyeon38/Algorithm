package Beginner_Coder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 자료처리_1697_큐Queue {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		Queue<String> queue = new LinkedList<String>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			
			if(str.equals("i")) {
				queue.offer(st.nextToken());
			} else if(str.equals("o")) {
				if(queue.size() != 0) {
					sb.append(queue.poll()).append("\n");
				} else {
					sb.append("empty").append("\n");
				}
			} else { // "c"
				sb.append(queue.size()).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
