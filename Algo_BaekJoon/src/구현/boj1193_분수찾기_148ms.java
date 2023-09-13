package 구현;

import java.util.*;
import java.io.*;

public class boj1193_분수찾기_148ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine()); // 1~10000000
		int n = 1;
		while(true) {
			if(n*(n+1)/2 < X) {
				n++;
			} else break;
		}
		
		// 분모, 분자의 합이 n+1
		int n1 = X-n*(n-1)/2;
		int n2 = n+1-n1;
		
		if((n+1)%2 == 0) {
			System.out.println(n2+"/"+n1);
		} else {
			System.out.println(n1+"/"+n2);
		}
	}
}
