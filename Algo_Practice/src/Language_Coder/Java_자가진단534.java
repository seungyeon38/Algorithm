package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_자가진단534 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char c = br.readLine().charAt(0);
		
		if(c == 'A') {
			System.out.println("Excellent");
		} else if(c == 'B') {
			System.out.println("Good");
		} else if(c == 'C') {
			System.out.println("Usually");
		} else if(c == 'D') {
			System.out.println("Effort");
		} else if(c == 'F') {
			System.out.println("Failure");
		} else {
			System.out.println("error");
		}
	}
}