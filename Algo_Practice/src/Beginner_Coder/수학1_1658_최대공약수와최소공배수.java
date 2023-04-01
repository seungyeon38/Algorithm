package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학1_1658_최대공약수와최소공배수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());
		int n1 = N1;
		int n2 = N2;
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
		}
		
		System.out.println(n1);
		System.out.println(N1*N2/n1);
	}
}
