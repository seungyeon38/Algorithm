package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_형성평가115 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int h1 = Integer.parseInt(st.nextToken());
		int w1 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int h2 = Integer.parseInt(st.nextToken());
		int w2 = Integer.parseInt(st.nextToken());
		
		boolean result = false; 
		
		if(h1>h2 && w1>w2) result = true; 
		
		System.out.println(result);
	}
}