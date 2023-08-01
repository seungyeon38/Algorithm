package Practice;

import java.util.*;
import java.io.*;

public class boj2776_암기왕_1640ms_Set {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			Set<Integer> nums = new HashSet<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				nums.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				if(nums.contains(Integer.parseInt(st.nextToken()))) {
					sb.append("1\n");
				} else sb.append("0\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
