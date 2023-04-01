package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_자가진단532 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		double d1 = Double.parseDouble(st.nextToken());
		double d2 = Double.parseDouble(st.nextToken());
		
		if(d1>=4.0 && d2>=4.0) {
			System.out.println("A");
		} else if(d1>=3.0 && d2>=3.0) {
			System.out.println("B");
		} else {
			System.out.println("C");
		}
	}
}