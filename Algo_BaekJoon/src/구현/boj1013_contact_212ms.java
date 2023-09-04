package 구현;

import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

public class boj1013_contact_212ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++) {
			String str = br.readLine();
			boolean result = Pattern.matches("(100+1+|01)+", str);
			
			sb.append(result ? "YES\n" : "NO\n");
		}
		
		System.out.println(sb.toString());
	}
}
