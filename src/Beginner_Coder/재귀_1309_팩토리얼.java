package Beginner_Coder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 재귀_1309_팩토리얼 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(factorial(n));
	}
	
	public static long factorial(int n) {
		if(n == 1) {
			System.out.println("1! = 1");
			return 1;
		}
		System.out.println(n+"! = "+n+" * "+(n-1)+"!");
		
		return n*factorial(n-1);
	}
}
