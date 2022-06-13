package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_형성평가162 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[10];
		arr[0] = n1;
		arr[1] = n2; 
		
		for(int i=2; i<10; i++) {
			arr[i] = (arr[i-1] + arr[i-2])%10;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<10; i++) {
			sb.append(arr[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}

