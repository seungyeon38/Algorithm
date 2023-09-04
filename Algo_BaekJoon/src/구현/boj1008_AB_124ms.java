package 구현;

import java.util.*;
import java.io.*;

public class boj1008_AB_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		double result = (double)A/B;
		System.out.println(result);
	}
}
