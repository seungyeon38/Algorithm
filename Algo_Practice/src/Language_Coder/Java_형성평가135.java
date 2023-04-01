package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_형성평가135 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		int num = 0;
		
		if(n1 > n2) {
			for(int i=n2; i<=n1; i++) {
				if(i%3 == 0 || i%5 == 0) {
					sum += i;
					num++;					
				}
			}
		} else {
			for(int i=n1; i<=n2; i++) {
				if(i%3 == 0 || i%5 == 0) {
					sum += i;
					num++;
				}
			}
		}
		
		System.out.println("sum : "+sum);
		System.out.printf("avg : %.1f", (double)sum/num);
	}
}