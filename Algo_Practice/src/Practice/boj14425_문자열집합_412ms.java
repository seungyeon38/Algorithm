package Practice;

import java.util.*;
import java.io.*;

public class boj14425_문자열집합_412ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 문자열 개수 1~10000
		int M = Integer.parseInt(st.nextToken()); // 검사해야 하는 문자열 개수 1~10000
		
		Set<String> strings = new HashSet<String>();
		for(int i=0; i<N; i++) {
			strings.add(br.readLine());
		}
		
		int result = 0;
		for(int j=0; j<M; j++) {
			if(strings.contains(br.readLine())) result++; 
		}
		
		System.out.println(result);
	}
}
