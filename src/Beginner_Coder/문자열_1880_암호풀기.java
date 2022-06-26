package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_1880_암호풀기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] encrypt = br.readLine().toCharArray();
		char[] content = br.readLine().toCharArray();
		int big_s = 'A';
		int big_e = 'Z';
		int diff = 'A'-'a';
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<content.length; i++) {
			if(content[i] == ' ') {
				sb.append(' ');
			} else if(big_s <= content[i] && content[i] <= big_e) { // 대문자 
				sb.append((char)(encrypt[content[i]-diff-'a']+diff));
			} else {
				sb.append(encrypt[content[i]-'a']);
			}
		}
		
		System.out.println(sb.toString());
	}
}
