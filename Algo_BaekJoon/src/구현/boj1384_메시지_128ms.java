package 구현;

import java.util.*;
import java.io.*;

public class boj1384_메시지_128ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 참여한 아이들 수 5~20
		StringBuilder sb = new StringBuilder();
		int idx = 1;
		
		while(n != 0) {
			sb.append("Group ").append(idx).append("\n");
			String[] names = new String[n];
			ArrayList<Integer>[] result = new ArrayList[n];
			
			for(int i=0; i<n; i++) {
				result[i] = new ArrayList<>();
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				names[i] = st.nextToken();
				
				for(int j=1; j<n; j++) {
					// i-j번째 애가 
					if(st.nextToken().charAt(0) == 'N') {
						int p = i-j;
						result[i].add(p>=0 ? p : p+n);
					}
				}
			}
			
			boolean hasNasty = false; 
			for(int i=0; i<n; i++) {
				if(result[i].size() != 0) {
					hasNasty = true; 
					for(int p : result[i]) {
						sb.append(names[p]).append(" was nasty about ").append(names[i]).append("\n");
					}
				}
			}
			
			if(!hasNasty) sb.append("Nobody was nasty\n");
			
			sb.append("\n");
			n = Integer.parseInt(br.readLine());
			idx++;
		}
		
		System.out.println(sb.toString());
	}
}
