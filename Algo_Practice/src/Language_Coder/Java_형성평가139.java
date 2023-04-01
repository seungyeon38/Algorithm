package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_형성평가139 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		
		if(n1 > n2) {
			for(int j=1; j<10; j++) {
				for(int i=n1; i>=n2; i--) {
					System.out.printf("%d * %d = %2d   ", i, j, i*j);
				}
				System.out.println();
			}
		} else {
			for(int j=1; j<10; j++) {
				for(int i=n1; i<=n2; i++) {
					System.out.printf("%d * %d = %2d   ", i, j, i*j);
				}
				System.out.println();
			}			
		}
	}
}