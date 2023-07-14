package class5_2;

import java.util.*;
import java.io.*;

public class boj2467_용액_384ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 전체 용액의 수 2~100000
		int[] water = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			water[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(water);
		
		int p1 = 0; 
		int p2 = N-1;
		int result = Integer.MAX_VALUE;
		int n1 = 0;
		int n2 = 0; 
		
		while(p1 < p2) {
			int sum = water[p1]+water[p2];
			if(result > Math.abs(sum)) {
				result = Math.abs(sum);
				n1 = water[p1];
				n2 = water[p2];
			}
			
			if(water[p1] < 0) {
				if(water[p2] < 0) { // 음수 음수 
					if(p1 == p2-1) break;
					else p1 = p2-1;
				} else { // 음수 양수 
					if(sum == 0) {
						break;
					} else if(sum < 0){
						p1++;
					} else {
						p2--;
					}
				}
			} else { // 양수 양수 
				if(p2 == p1+1) break; 
				else p2 = p1+1;
			}
		}
		
		System.out.println(n1 + " " + n2);
	}
}
