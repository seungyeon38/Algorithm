package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_형성평가134 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n;
		int odd_n = 0;
		int even_n = 0;
		
		for(int i=0; i<10; i++) {
			n = Integer.parseInt(st.nextToken());
			
			if(n%2 == 0) {
				even_n++;
			} else {
				odd_n++;
			}
		}
		
		System.out.println("even : "+even_n);
		System.out.println("odd : "+odd_n);
	}
}