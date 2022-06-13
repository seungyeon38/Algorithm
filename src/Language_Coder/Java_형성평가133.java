package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_형성평가133 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		int num = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			sum += Integer.parseInt(st.nextToken());
			num++;
		}
		
		System.out.printf("%.2f", (double)sum/num);
	}
}