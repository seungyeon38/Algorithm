package Practice;

import java.util.*;
import java.io.*; 

public class boj10815_숫자카드_888ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자 카드 개수 1~500000
		Set<Integer> nums = new HashSet<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums.add(Integer.parseInt(st.nextToken())); // -10000000~10000000
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			if(nums.contains(Integer.parseInt(st.nextToken()))) sb.append("1 ");
			else sb.append("0 ");
		}
		
		System.out.println(sb.toString());
		
		String str1 = "안녕";
		Set<String> set = new HashSet<String>();
		set.add(str1);
		String str2 = "안녕";
		System.out.println(set.contains(str2));
	}
}
