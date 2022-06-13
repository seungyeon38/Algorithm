package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_형성평가117 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		double d1 = Double.parseDouble(st.nextToken());
		double d2 = Double.parseDouble(st.nextToken());
		double d3 = Double.parseDouble(st.nextToken());
		double sum = d1+d2+d3;
		System.out.println("sum " + ((int)d1+(int)d2+(int)d3));
		System.out.println("avg " + (int)(sum/3));
	}
}