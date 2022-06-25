package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수학1_1430_숫자의개수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());

		int multi = a*b*c;
		
		int[] result = new int[10];
		
		while(multi != 0) {
			result[multi%10]++;
			multi /= 10;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<10; i++) {
			sb.append(result[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
