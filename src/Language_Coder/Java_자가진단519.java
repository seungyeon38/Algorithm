package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_자가진단519 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n1 = Integer.parseInt(st.nextToken())+100;
		int n2 = Integer.parseInt(st.nextToken())%10;
		
		System.out.println(n1+" "+n2);
		
	}
}