package 구현;

import java.util.*;
import java.io.*; 

public class boj1049_기타줄_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 1~100
		int M = Integer.parseInt(st.nextToken()); // 1~50 
		
		int min_package = Integer.MAX_VALUE;
		int min_one = Integer.MAX_VALUE;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int package_p = Integer.parseInt(st.nextToken()); // 0~1000 패키지(6개) 가격 
			int one_p = Integer.parseInt(st.nextToken()); // 0~1000 낱개 가격
			
			min_package = Math.min(min_package, package_p);
			min_one = Math.min(min_one, one_p);
		}
		
		int result = 0; 
		if(min_one*6 <= min_package) {
			result = N*min_one;
		} else if(min_package/6 < min_one) {
			int n = N/6;
			N %= 6;
			
			if(min_one*N < min_package) result = n*min_package + min_one*N;
			else result = (n+1)*min_package;
		}
		
		System.out.println(result);
	}
}
