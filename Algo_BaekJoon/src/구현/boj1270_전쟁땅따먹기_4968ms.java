package 구현;

import java.util.*;
import java.io.*;

public class boj1270_전쟁땅따먹기_4968ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 땅의 개수 1~200
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			Map<Long,Integer> map = new HashMap<>();
			
			for(int j=0; j<cnt; j++) {
				long num = Long.parseLong(st.nextToken());
				if(map.containsKey(num)) {
					map.put(num, map.get(num)+1);
				} else {
					map.put(num, 1);
				}
			}
			
			boolean hasResult = false; 
			
			for(long key : map.keySet()) {
				int value = map.get(key);
				if(cnt/2 < value) {
					hasResult = true; 
					sb.append(key).append("\n");
					break;
				}
			}
			
			if(!hasResult) {
				sb.append("SYJKGW\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
