package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_자가진단517 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double d1 = Double.parseDouble(br.readLine());
		double d2 = Double.parseDouble(br.readLine());
		double d3 = Double.parseDouble(br.readLine());
		
		System.out.printf("%.3f\n", d1);
		System.out.printf("%.3f\n", d2);
		System.out.printf("%.3f\n", d3);
	}
}