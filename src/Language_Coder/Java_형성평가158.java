package Language_Coder;

import java.io.IOException;
import java.util.Scanner;

public class Java_형성평가158 {
	public static void main(String[] args) throws IOException {	
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[100];
		int n;
		int i=0; 
		while((n = sc.nextInt()) != 0) {
			arr[i++] = n;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(i).append("\n");
		
		for(int j=0; j<i; j++) {
			if(arr[j]%2 == 0) {
				sb.append(arr[j]/2).append(" ");
			} else {
				sb.append(arr[j]*2).append(" ");
			}
		}
		
		System.out.println(sb.toString());
	}
}

