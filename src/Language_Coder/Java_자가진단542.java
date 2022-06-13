package Language_Coder;

import java.io.IOException;

public class Java_자가진단542 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		StringBuilder sb = new StringBuilder();
		
		for(int i=10; i<21; i++) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}