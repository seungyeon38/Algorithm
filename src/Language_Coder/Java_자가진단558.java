package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_자가진단558 {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[100];
		int n;
		int num = 0;
		while((n = sc.nextInt()) != 0) {
			arr[num] = n;
			num++;
		}

		StringBuilder sb = new StringBuilder();
		for(int i=num-1; i>=0; i--) {
			sb.append(arr[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}