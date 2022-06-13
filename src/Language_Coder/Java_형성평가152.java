package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_형성평가152 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[10];
		
		for(int i=0; i<10; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int odd_sum = 0;
		int even_sum = 0;
		
		for(int i=0; i<10; i++) {
			if(i%2 == 0) {
				odd_sum += arr[i];
			} else {
				even_sum += arr[i];
			}
		}
		
		System.out.println("odd : "+odd_sum);
		System.out.println("even : "+even_sum);
	}
}

