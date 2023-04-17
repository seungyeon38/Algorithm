package day2;

import java.util.*;
import java.io.*;

public class boj13305_주유소_S3_432ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 도시 수 2~100000
		int[] distance = new int[N];
		int[] price = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<N; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		int cur_min = price[0];
		long result = 0; 
		
		for(int i=1; i<N; i++) {
			result += (long)cur_min*(long)distance[i];
			if(price[i] < cur_min) cur_min = price[i];
		}
		
		System.out.println(result);
	}
}
