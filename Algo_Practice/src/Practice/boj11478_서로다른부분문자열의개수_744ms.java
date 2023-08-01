package Practice;

import java.util.*;
import java.io.*;

public class boj11478_서로다른부분문자열의개수_744ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine(); // 1000 이하 
		int size = S.length();
		
		Set<String> set = new HashSet<String>();
		for(int i=0; i<size; i++) {
			for(int j=i+1; j<=size; j++) {
				set.add(S.substring(i,j));
			}
		}
		
		System.out.println(set.size());
	}
}
