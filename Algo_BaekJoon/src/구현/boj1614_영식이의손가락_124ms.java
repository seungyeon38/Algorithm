package 구현;

import java.util.*;
import java.io.*;

public class boj1614_영식이의손가락_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 다친 손가락 번호
		int max = Integer.parseInt(br.readLine()); // 다친 손가락으로 셀 수 있는 횟수 0~1000000000
		
		long result = 0;
		if(n == 1) result = (long)max*8;
		else if(n == 2) {
			result = 1 + (long)(max/2)*8;
			if(max%2 == 1) result += 6; 
		} else if(n == 3) {
			result = 2 + (long)max*4;
		} else if(n == 4) {
			result = 3 + (long)(max/2)*8;
			if(max%2 == 1) result += 2;
		} else if(n == 5) {
			result = 4 + (long)max*8;
		}
		
		System.out.println(result);
	}
}
