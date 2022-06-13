package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_형성평가172 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		print(Integer.parseInt(br.readLine()));
		
	}
	
	public static void print(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(i*j + " ");
			}
			System.out.println();
		}
	}
}

