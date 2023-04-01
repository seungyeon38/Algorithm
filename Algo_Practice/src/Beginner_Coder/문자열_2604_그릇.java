package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열_2604_그릇 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] c_arr = br.readLine().toCharArray();
		boolean dir = true; 
		int result = 10;
		
		if(c_arr[0] == ')') dir = false; 
		
		for(int i=1; i<c_arr.length; i++) {
			if(c_arr[i] == c_arr[i-1]) result += 5;
			else {
				dir = !dir; 
				result += 10;
			}
		}
		
		System.out.println(result);
	}
}
