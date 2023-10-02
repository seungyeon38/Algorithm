package 구현;

import java.util.*;
import java.io.*;

public class boj1360_되돌리기_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 명령의 개수 1~50
		Stack<String[]> stack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			stack.add(new String[] {st.nextToken(), st.nextToken(), st.nextToken()});
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!stack.isEmpty()) {
			String[] cur = stack.pop();
			
			if(cur[0].equals("type")) {
				char c = cur[1].charAt(0);
				sb.append(c);
			} else { // undo 
				int n = Integer.parseInt(cur[1]);
				int t = Integer.parseInt(cur[2]); // 수행 시간 
				if(stack.isEmpty()) break;
				
				while(!stack.isEmpty()) {
					String[] next = stack.peek();
					if(Integer.parseInt(next[2]) >= t-n) {
						stack.pop();
					} else break;
				}
			}
		}
		
		System.out.println(sb.reverse().toString());
	}
}
