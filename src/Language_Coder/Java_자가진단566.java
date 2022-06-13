package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_자가진단566 {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		int[] arr = new int[101];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr[0] = 100;
		arr[1] = n;
		int i = 1;
		while(arr[i++] >= 0) {
			arr[i] = arr[i-2] - arr[i-1];
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int j=0; j<i; j++) {
			sb.append(arr[j]).append(" ");
		}
	
		System.out.println(sb.toString());
	}
}