package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_자가진단533 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		char s = st.nextToken().charAt(0);
		int y = Integer.parseInt(st.nextToken());
		
		if(s == 'M') {
			if(y >= 18) {
				System.out.println("MAN");
			} else {
				System.out.println("BOY");
			}
		} else {
			if(y >= 18) {
				System.out.println("WOMAN");
			} else {
				System.out.println("GIRL");
			}			
		}
	}
}