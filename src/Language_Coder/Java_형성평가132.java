package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_형성평가132 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		
		for(int i=1; i<=n; i++){
			if(i%5 == 0) {
				result += i;
			}
		}
		
		System.out.println(result);
	}
}