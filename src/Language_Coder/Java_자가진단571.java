package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_자가진단571 {
	public static void print(int n) {
		for(int i=0; i<n; i++) {
			System.out.println("~!@#$^&*()_+|");
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		print(n);
	}
}