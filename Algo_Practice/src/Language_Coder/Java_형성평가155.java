package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_형성평가155 {
	public static void main(String[] args) throws IOException {	
		char[] arr = {'J', 'U', 'N', 'G', 'O', 'L'};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char c = br.readLine().charAt(0);
		
		int result = -1;
		for(int i=0; i<6; i++) {
			if(c == arr[i]) {
				result = i;
			}
		}
		
		if(result == -1) {
			System.out.println("none");
		} else {
			System.out.println(result);
		}
	}
}

