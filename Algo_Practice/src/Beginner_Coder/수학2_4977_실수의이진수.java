package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학2_4977_실수의이진수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double num = Double.parseDouble(br.readLine());
		
		int n = (int)num;
		double d = num-n;
		StringBuilder sb1 = new StringBuilder();
		
		while(n != 0) {
			sb1.append(n%2);
			n/=2;
		}
		
		sb1.reverse();
		
		StringBuilder sb2 = new StringBuilder();
		int cnt = 0;
		while(d != 0) {
			if(cnt == 4) break;
			
			d *= 2;
			sb2.append((int)d);
			d -= (int)d;
			
			cnt++;
		}
		
		int diff = 4-sb2.length();
		for(int i=0; i<diff; i++) {
			sb2.append("0");
		}
		
		System.out.println(sb1.toString()+"."+sb2.toString());
	}
}
