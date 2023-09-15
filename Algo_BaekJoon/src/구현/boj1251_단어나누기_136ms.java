package 구현;

import java.util.*;
import java.io.*;

public class boj1251_단어나누기_136ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine(); // 3~50
		int length = str.length();
		String result = null;
		
		// string에서 사전순으로 앞서는 알파벳 3개 찾기 
		for(int n1=1, max1=length-2; n1<max1; n1++) {
			for(int n2=n1+1; n2<length; n2++) {
				StringBuilder temp = new StringBuilder();

				temp.append(new StringBuilder(str.substring(0, n1)).reverse());
				temp.append(new StringBuilder(str.substring(n1, n2)).reverse());
				temp.append(new StringBuilder(str.substring(n2)).reverse());
				
				String temp_str = temp.toString();
				if(result==null || temp_str.compareTo(result)<0) {
					result = temp_str;
				}
			}
		}
		
		System.out.println(result);
	}
	
}
