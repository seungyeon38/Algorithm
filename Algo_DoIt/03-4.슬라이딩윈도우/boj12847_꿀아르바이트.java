package Algorithm;

import java.util.*;
import java.io.*;

public class boj12847 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 100000
		int m = Integer.parseInt(st.nextToken()); // 일할 수 있는 날
		
		int[] pay = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			pay[i] = Integer.parseInt(st.nextToken());
		}
		
		long max = 0;
		long temp = 0; 
		
		for(int i=0; i<m; i++) {
			temp += pay[i];
		}
		
		if(temp > max) max = temp; 
		
		int num = n-m;
		for(int i=0; i<num; i++) {
			temp -= pay[i];
			temp += pay[i+m];
			
			if(temp > max) max = temp;
		}
		
		System.out.println(max);
	}
}
