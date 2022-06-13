package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_자가진단546 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		double result = 0.0;
		int num = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			result += Integer.parseInt(st.nextToken());
			num++;
		}
		
		result /= num;
		
		System.out.printf("avg : %.1f\n", result);
		
		if(result < 80) {
			System.out.println("fail");
		} else {
			System.out.println("pass");
		}
	}
}