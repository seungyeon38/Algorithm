package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_형성평가154 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		double sum = 0.0;
		for(int i=0; i<6; i++) {
			sum += Double.parseDouble(st.nextToken());
		}
		
		System.out.printf("%.1f", sum/6);
	}
}

