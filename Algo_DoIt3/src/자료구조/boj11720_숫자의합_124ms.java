package 자료구조;

import java.util.*;
import java.io.*;

public class boj11720_숫자의합_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int result = 0;
		
		for(int i=0; i<N; i++) {
			result += str.charAt(i)-'0';
		}
		
		System.out.println(result);
	}
}
