package Language_Coder;

import java.io.IOException;

public class Java_자가진단556 {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		int[] arr = new int[10];
		
		for(int i=0; i<10; i++) {
			arr[i] = i+1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<10; i++) {
			sb.append(arr[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}