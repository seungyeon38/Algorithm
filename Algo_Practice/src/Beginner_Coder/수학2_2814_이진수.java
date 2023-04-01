package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학2_2814_이진수 {		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] c_arr = br.readLine().toCharArray();
		int result = 0;
		int n;
		for(int i=0; i<c_arr.length; i++) {
			n = c_arr[c_arr.length-i-1]-'0';
			for(int j=0; j<i; j++) {
				n*=2;				
			}
			result += n;
		}
		
		System.out.println(result);
	}
}
