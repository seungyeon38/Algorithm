package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수학1_1692_곱셈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n1 = Integer.parseInt(br.readLine());
		int n2 = Integer.parseInt(br.readLine());
		
		int n3, n4, n5, n6;
		
		int n2_1 = n2%10;
		int n2_10 = n2%100/10;
		int n2_100 = n2/100;
		
		n3 = n1*n2_1;
		n4 = n1*n2_10;
		n5 = n1*n2_100;
		
		n6 = n3 + n4*10 + n5*100;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(n3).append("\n").append(n4).append("\n").append(n5).append("\n").append(n6).append("\n");
		
		System.out.println(sb.toString());
	}
}
