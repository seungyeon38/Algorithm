package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_자가진단578 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		
		if(n1 < n2) {
			for(int i=n1; i<=n2; i++) {
				print(i);
			}
		} else {
			for(int i=n2; i<=n1; i++) {
				print(i);
			}			
		}
	}
	
	public static void print(int n) {
		System.out.println("== "+ n +"dan ==");
		for(int i=1; i<10; i++) {
			System.out.printf("%d * %d = %2d\n", n, i, n*i);
		}
		System.out.println();
	}
}