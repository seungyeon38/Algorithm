package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_자가진단573 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		print(n);
	}
	
	public static void print(int n) {
//		정수 n을 전달받아 숫자 정사각형을 출력하는 함수
		int num = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(num++ + " ");
			}
			System.out.println();
		}
	}
}