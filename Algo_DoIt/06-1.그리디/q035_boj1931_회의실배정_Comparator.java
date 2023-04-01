package Algorithm;

import java.util.*;
import java.io.*;

public class q035_boj1931_Comparator {
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
		
		Arrays.sort(arr, new Comparator<Conference>() {
			@Override 
			public int compare(Conference c1, Conference c2) {
				if(c1.et == c2.et) return c1.st-c2.st;
				
				return c1.et-c2.et;
			}
		});
		
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
	
	public static class Conference{
		int st; 
		int et; 
		
		Conference(int st, int et){
			this.st = st; 
			this.et = et; 
		}
	}
}
