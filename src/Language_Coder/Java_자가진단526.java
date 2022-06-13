package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_자가진단526 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		double d1 = Double.parseDouble(st.nextToken());
		double d2 = Double.parseDouble(st.nextToken());
		
		System.out.printf("%d %d", (int)(d1*d2), (int)d1*(int)d2);
	}
}