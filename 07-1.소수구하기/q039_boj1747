package Algorithm;

import java.util.*;
import java.io.*;

public class q039_boj1747 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1000000
		
		int[] arr = new int[1003003];
		
		for(int i=2; i<=1003002; i++) {
			arr[i] = i;
		}
		
		int max = (int)Math.sqrt(1003002);
		
		for(int i=2; i<=max; i++) {
			if(arr[i] == 0) continue; 
			
			for(int j=2*i; j<=1003002; j+=i) {
				arr[j] = 0;
			}
		}
		
		for(int i=N; i<=1003002; i++) {
			if(arr[i] != 0) { // 소수이면  
				char[] c_arr = Integer.toString(i).toCharArray();
				int sp = 0; 
				int ep = c_arr.length-1; 
				boolean result = true; 
				
				while(sp < ep) {
					if(c_arr[sp] != c_arr[ep]) {
						result = false; 
						break; 
					}
					sp++; 
					ep--;
				}
				
				if(result) {
					System.out.println(i);
					break;
				}
			}
		}
	}
}
