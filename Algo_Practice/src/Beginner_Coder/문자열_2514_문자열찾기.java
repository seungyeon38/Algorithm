package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열_2514_문자열찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] c_arr = br.readLine().toCharArray();
		int KOI_n = 0;
		int IOI_n = 0;
		for(int i=0, size=c_arr.length-2; i<size; i++) {
			if(c_arr[i+1]=='O' && c_arr[i+2]=='I') {
				if(c_arr[i]=='K') {
					KOI_n++;
				} else if(c_arr[i]=='I') {
					IOI_n++;
				}
			}
		}
		System.out.println(KOI_n);
		System.out.println(IOI_n);
	}
}
