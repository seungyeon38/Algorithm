package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_형성평가171 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		print(Integer.parseInt(br.readLine()));
	}
	
	public static void print(int n) {
		int sum = 0;
		for(int i=1; i<=n; i++) {
			sum += i;
		}
		
		System.out.println(sum);
	}
}

