package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학1_1002_최대공약수최소공배수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int gcd = arr[0]; // 최대공약수 
		int lcm = arr[0]; // 최소공배수 
		
		for(int i=1; i<n; i++) {
			gcd = getGcd(gcd, arr[i]);
			lcm = lcm*arr[i]/getGcd(lcm, arr[i]);
//			System.out.println();
		}
		
		System.out.println(gcd + " " + lcm);
	}
	
	public static int getGcd(int n1, int n2) {
		int temp;
		
		if(n1 < n2) {
			temp = n1;
			n1 = n2; 
			n2 = temp;
		}
		
		while(n2 != 0) {
			temp = n2;
			n2 = n1%n2;
			n1 = temp;
			
//			System.out.println(n1 + " " + n2);
		}
		
		return n1;
	}
}
