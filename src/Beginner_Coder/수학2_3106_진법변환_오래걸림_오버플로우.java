package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학2_3106_진법변환_오래걸림_오버플로우 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String s = null;
		StringBuilder sb = new StringBuilder();
		while(!(s = br.readLine()).equals("0")) {
			st = new StringTokenizer(s);
			int A = Integer.parseInt(st.nextToken()); // A진법 
			String S = st.nextToken(); // 수 
			int B = Integer.parseInt(st.nextToken()); // B진법 
			
			if(S.equals("0") || A == B) {
				sb.append(S);
			} else {
				sb.append(from10(to10(S.toCharArray(), A), B));				
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	// 10진법으로
	public static long to10(char[] n, int notation) {
		long result = 0;
		long mul = 1;
		
		if(notation <= 10) {
			for(int i=0, size=n.length-1; i<=size; i++) {
				result += (n[size-i]-'0')*mul;
				mul *= notation;
			}
		} else {
			int num = 0;
			for(int i=0, size=n.length-1; i<=size; i++) {
				num = n[size-i];
				if('A' <= num && num <= 'Z') {
					num = num-'A'+10;
				} else {
					num -= '0';
				}
				result += num * mul;
				mul *= notation;
			}
		}

		return result;
	}
	
	// 10진법에서
	public static String from10(long n, int notation) {
		StringBuilder sb = new StringBuilder();
		
		if(notation <= 10) {
			while(n != 0) {
				sb.append(n%notation);
				n /= notation;
			}
		} else {
			long num = 0;
			while(n != 0) {
				num = n%notation;
				if(num > 9) {
					sb.append((char)(num-10+'A'));
				} else {
					sb.append(num);
				}
				n /= notation;
			}
		}

		return sb.reverse().toString();
	}
}
