package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_자가진단541 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char c = br.readLine().charAt(0);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<20; i++) sb.append(c);
		
		System.out.println(sb.toString());
	}
}