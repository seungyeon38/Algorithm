package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_자가진단575 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		System.out.println(calc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
	}
	
	public static int calc(int n1, int n2) {
		int result = 1;
		
		for(int i=0; i<n2; i++) {
			result *= n1; 
		}
		
		return result;
	}
}