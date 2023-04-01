package Language_Coder;

import java.io.IOException;

public class Java_자가진단548 {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		for(int i=2; i<5; i++) {
			for(int j=1; j<6; j++) {
				System.out.printf("%-2d*%2d =%3d   ", i, j, i*j);
			}
			System.out.println();
		}
	}
}