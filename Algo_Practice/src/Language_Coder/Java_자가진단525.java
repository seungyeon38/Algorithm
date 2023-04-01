package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_자가진단525 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		int n3 = Integer.parseInt(st.nextToken());
		
		boolean result1 = false; 
		boolean result2 = false; 
		
		if(n1>n2 && n1>n3) {
			result1 = true;
		}
		
		if(n1==n2 && n1==n3) {
			result2 = true;
		}
		
		System.out.println(result1 + " " + result2);
	}
}