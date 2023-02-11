package Algorithm;

import java.util.*;
import java.io.*;

public class q021_boj1517 {
	public static int[] arr, temp; 
	public static long result = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 500000
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		temp = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		mergesort(0, N-1);
		
		System.out.println(result);
	}
	
	public static void mergesort(int sp, int ep) {
		if(ep <= sp) return; 
		
		int mp = sp + (ep-sp)/2;
		
		mergesort(sp, mp);
		mergesort(mp+1, ep);
		
		int idx1 = sp; 
		int idx2 = mp+1;
		int idx = sp; 
		
		for(int i=sp; i<=ep; i++) {
			temp[i] = arr[i];
		}
		
		while(idx1 <= mp && idx2 <= ep) {
			if(temp[idx1] <= temp[idx2]) {
				arr[idx++] = temp[idx1++]; 
			} else {
				arr[idx++] = temp[idx2++];
				result += idx2-idx;
			}
		}
		
		while(idx1 <= mp) {
			arr[idx++] = temp[idx1++];
		}
		
		while(idx2 <= ep) {
			arr[idx++] = temp[idx2++];
		}
	}
}
