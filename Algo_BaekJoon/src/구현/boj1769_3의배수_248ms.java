package 구현;

import java.util.*;
import java.io.*;

public class boj1769_3의배수_248ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String X = br.readLine();
		int result = 0;
		
		while(X.length() > 1) {
			X = q1(X);
			result++;
		}
		
		System.out.println(result);
		System.out.println((Integer.parseInt(X)%3 == 0) ? "YES" : "NO");
	}
	
	public static String q1(String n) { // 자리의 수를 더하기 
		int result = 0;

		for(int i=0, len=n.length(); i<len; i++) {
			result += n.charAt(i)-'0';
		}
		
		return String.valueOf(result);
	}
}
