package Language_Coder;

import java.io.IOException;

public class Java_자가진단567 {
	public static void main(String[] args) throws NumberFormatException, IOException {	
//		 5    8   10    6    4
//		 11   20    1   13    2
//		  7    9   14   22    3
		
		int[][] arr = {{5, 8, 10, 6, 4}, {11, 20, 1, 13, 2}, {7, 9, 14, 22, 3}};
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<5; j++) {
				System.out.printf("%2d   ", arr[i][j]);
			}
			System.out.println();
		}
	}
}