package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_자가진단562 {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[10];
		
		for(int i=0; i<10; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum_odd = 0;
		int sum_even = 0;
		for(int i=0; i<10; i++) {
			if(i%2 == 0) { // 홀수 
				sum_odd += arr[i];
			} else {
				sum_even += arr[i];
			}
		}
		
		System.out.println("sum : "+sum_even);
		System.out.printf("avg : %.1f", (double)sum_odd/5);
	}
}