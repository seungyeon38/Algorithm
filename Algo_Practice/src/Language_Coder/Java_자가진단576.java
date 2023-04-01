package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_자가진단576 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n1 = Integer.parseInt(st.nextToken());
		char c = st.nextToken().charAt(0);
		int n2 = Integer.parseInt(st.nextToken());
		
		int result = calc(n1, c, n2);
		
		System.out.printf("%d %c %d = %d", n1, c, n2, result);
	}
	
	public static int calc(int n1, char c, int n2) {
		switch(c) {
		case '+':
			return n1+n2;
		case '-':
			return n1-n2;
		case '*':
			return n1*n2; 
		case '/':
			return n1/n2;
		}
		return 0;
	}
}