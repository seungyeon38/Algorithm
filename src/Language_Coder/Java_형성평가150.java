package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_형성평가150 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		char[] c_arr = new char[10];
		
		for(int i=0; i<10; i++) {
			c_arr[i] = st.nextToken().charAt(0);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=9; i>=0; i--) {
			sb.append(c_arr[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}

