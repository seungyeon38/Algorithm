package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_자가진단557 {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		char[] c_arr = new char[10];
		
		for(int i=0; i<10; i++) {
			c_arr[i] = st.nextToken().charAt(0);
		}
		
		System.out.println(c_arr[0]+" "+c_arr[3]+" "+c_arr[6]);
	}
}