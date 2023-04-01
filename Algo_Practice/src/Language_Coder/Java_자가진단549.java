package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_자가진단549 {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		int num = 0;
		int i = 1;
		
		while(sum < n) {
			if(i%2 != 0) {
				sum += i;
				num++;
			}
			i++;
		}
		
		System.out.println(num + " " + sum);
	}
}