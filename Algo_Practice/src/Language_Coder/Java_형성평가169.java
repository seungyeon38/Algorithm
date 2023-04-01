package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_형성평가169 {
	public static void main(String[] args) throws IOException {	
		char[][] c_arr = new char[3][5];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int diff = 'A' - 'a';
		
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				c_arr[i][j] = st.nextToken().charAt(0);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<3; i++) {
			for(int j=0; j<5; j++) {
				sb.append((char)(c_arr[i][j]-diff)).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

