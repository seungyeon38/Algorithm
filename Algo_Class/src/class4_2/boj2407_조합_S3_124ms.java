package class4_2;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class boj2407_조합_S3_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 5~100
		int m = Integer.parseInt(st.nextToken()); // 5~n 
		
		BigInteger n1 = BigInteger.ONE;
		BigInteger n2 = BigInteger.ONE;
		
		for(int i=0; i<m; i++) {
			n1 = n1.multiply(new BigInteger(Integer.toString(n-i)));
			n2 = n2.multiply(new BigInteger(Integer.toString(i+1)));
		}
		
		System.out.println(n1.divide(n2));
	}
}
