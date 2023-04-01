package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_형성평가111 {
	public static void main(String[] args) throws IOException {			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int sc1 = Integer.parseInt(st.nextToken());
		int sc2 = Integer.parseInt(st.nextToken());
		int sc3 = Integer.parseInt(st.nextToken());
		int sc4 = Integer.parseInt(st.nextToken());
		int sum = sc1+sc2+sc3+sc4;
		System.out.println("sum " + sum);
		System.out.printf("avg %d", sum/4);
	}
}