package 구현;

import java.util.*;
import java.io.*;

public class boj1015_수열정렬_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 배열 A의 크기 1~50
		StringTokenizer st = new StringTokenizer(br.readLine());
		Num[] nums = new Num[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = new Num(Integer.parseInt(st.nextToken()), i);
		}
		
		Arrays.sort(nums);
		
		int[] result = new int[N];
		for(int i=0; i<N; i++) {
			result[nums[i].idx] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : result) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	
	public static class Num implements Comparable<Num>{
		int n;
		int idx; 
		
		Num(int n, int idx){
			this.n = n;
			this.idx = idx;
		}
		
		@Override 
		public int compareTo(Num n){
			return this.n-n.n;
		}
	}
}
