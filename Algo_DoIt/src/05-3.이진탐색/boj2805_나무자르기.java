import java.util.*;
import java.io.*;

public class boj2805_나무자르기 {
	static int N, M;
	static int[] trees;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 나무 수 1000000
		M = Integer.parseInt(st.nextToken()); // 길이 2000000000
		trees = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		int end = 0; // 1,000,000,000
		for(int i=0; i<N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			end = Math.max(end, trees[i]); 
		}
		
		int start = 0;
		int result = 0;
		while(start <= end) {
			int mid = (start+end)/2;
			long length = getLength(mid);
			
			if(length < M) {
				end = mid-1;
			} else {
				result = Math.max(result, mid);
				start = mid+1;	
			}
		}
		
		System.out.println(result);
	}
	
	public static long getLength(int height) {
		long length = 0;
		
		for(int i=0; i<N; i++) {
			int diff = trees[i]-height;
			if(diff > 0) length += diff;
		}
		
		return length;
	}
}
