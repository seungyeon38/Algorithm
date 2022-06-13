package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_형성평가121 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		if(n == 0) {
			System.out.println("zero");
		} else if(n > 0) {
			System.out.println("plus");
		} else {
			System.out.println("minus");
		}
	}
}