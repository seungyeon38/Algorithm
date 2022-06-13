package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_자가진단535 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double s = Double.parseDouble(br.readLine());
		
		switch((int)s) {
		case 4:
			System.out.println("scholarship");			
			break; 
		case 3: 
			System.out.println("next semester");
			break; 
		case 2: 
			System.out.println("seasonal semester");
			break; 
		case 1:
		case 0:
			System.out.println("retake");
		}
	}
}