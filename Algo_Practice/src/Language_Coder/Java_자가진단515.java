package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_자가진단515 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		System.out.println(n1+" * "+n2+" = "+n1*n2);
		System.out.println(n1+" / "+n2+" = "+n1/n2);
//		System.out.printf("%d * %d = %d\n", n1, n2, n1*n2);
//		System.out.printf("%d / %d = %d", n1, n2, n1/n2);
	}
}