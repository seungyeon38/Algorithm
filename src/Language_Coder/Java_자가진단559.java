package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_자가진단559 {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		double[] arr = {85.6, 79.5, 83.1, 80.0, 78.2, 75.0};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		
		System.out.println(arr[n1-1]+arr[n2-1]);
	}
}