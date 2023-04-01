package Algorithm;

import java.util.*;
import java.io.*;

public class q035_boj1931_Comparable {
	static Conference[] arr; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 100000
		
		StringTokenizer st;
		arr = new Conference[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i] = new Conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(arr);
		
		int temp_et = arr[0].et;
		int result = 1; 
		
		for(int i=1; i<N; i++) {
			if(temp_et <= arr[i].st) {
				temp_et = arr[i].et;
				result++;
			}
		}
		
		System.out.println(result);
	}
	
	public static class Conference implements Comparable<Conference>{
		int st; 
		int et; 
		
		Conference(int st, int et){
			this.st = st; 
			this.et = et; 
		}

		@Override
		public int compareTo(Conference o) { 
			int result = this.et - o.et;
			if(result == 0) return this.st - o.st;
			
			return result;
		}
	}
}
