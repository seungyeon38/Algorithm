package Algorithm;

import java.util.*;
import java.io.*;

public class q017_boj1427 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1000000000
		String str = Integer.toString(N);
		int[] arr = new int[str.length()];
		int idx = str.length()-1;

		while(idx >= 0) {
			arr[idx] = N%10;
			N /= 10;
			idx--;
		}
				
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=str.length()-1; i>=0; i--) {
			sb.append(arr[i]);
		}
		
		System.out.println(sb.toString());
	}
}
