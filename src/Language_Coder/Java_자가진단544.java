package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_자가진단544 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		
		for(int i=n; i<101; i++) {
			result += i;
		}
		
		System.out.println(result);
	}
}