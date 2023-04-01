package Language_Coder;

import java.io.IOException;

public class Java_자가진단547 {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		StringBuilder sb = new StringBuilder();
		
		for(int i=2; i<7; i++) {
			for(int j=i, size=i+5; j<size; j++) {
				sb.append(j).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}