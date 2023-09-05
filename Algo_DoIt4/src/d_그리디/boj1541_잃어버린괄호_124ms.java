package d_그리디;

import java.util.*;
import java.io.*;

public class boj1541_잃어버린괄호_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split("-");
		
		int result = 0;
		
		String[] cur = str[0].split("\\+");
		
		for(int size2=cur.length, j=0; j<size2; j++) {
			result += Integer.parseInt(cur[j]);
		}
		
		for(int size=str.length, i=1; i<size; i++) {
			cur = str[i].split("\\+");
			
			for(int size2=cur.length, j=0; j<size2; j++) {
				result -= Integer.parseInt(cur[j]);
			}
		}
		
		System.out.println(result);
	}
}
