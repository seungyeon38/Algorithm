package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_자가진단545 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n;
		int mul3 = 0;
		int mul5 = 0;
		for(int i=0; i<10; i++) {
			n = Integer.parseInt(st.nextToken());
			
			if(n%3 == 0) {
				mul3++;
			}
			if(n%5 == 0) {
				mul5++;
			}
		}
		
		System.out.println("Multiples of 3 : "+mul3);
		System.out.println("Multiples of 5 : "+mul5);
	}
}