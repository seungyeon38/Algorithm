package 탐색;

import java.util.*;
import java.io.*;

public class q029_boj1920_수찾기 {
	static int N; 
	static ArrayList<Integer> nums; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 1~100000
		nums = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(nums);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()); 
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			if(find(Integer.parseInt(st.nextToken()))){
				sb.append("1\n");
			} else sb.append("0\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static boolean find(int n) {
		int s = 0;
		int e = N-1;
		
		while(s <= e) {
			int mid = (s+e)/2;
			int num = nums.get(mid);
			if(num == n) {
				return true; 
			} else if(num < n) {
				s = mid+1;
			} else if(num > n) {
				e = mid-1;
			}
		}
		
		return false; 
	}
}	
