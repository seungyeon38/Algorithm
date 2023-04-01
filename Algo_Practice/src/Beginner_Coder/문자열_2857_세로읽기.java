package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 문자열_2857_세로읽기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] c_arr = new char[5][15];
		
		for(int i=0; i<5; i++) {
			Arrays.fill(c_arr[i], '[');
		}
		
		char[] temp;
		for(int i=0; i<5; i++) {
			temp = br.readLine().toCharArray();
			for(int j=0; j<temp.length; j++) {
				c_arr[i][j] = temp[j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<15; i++) {
			for(int j=0; j<5; j++) {
				if(c_arr[j][i] != '[') sb.append(c_arr[j][i]);
			}
		}
		
		System.out.println(sb.toString());
	}
}
