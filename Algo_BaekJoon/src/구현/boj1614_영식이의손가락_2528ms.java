package 구현;

import java.util.*;
import java.io.*;

public class boj1614_영식이의손가락_2528ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 다친 손가락 번호
		int max = Integer.parseInt(br.readLine()); // 다친 손가락으로 셀 수 있는 횟수 0~1000000000
		
		int cnt_n = 0;
		int dir = 1;
		long result = 0;
		
		if(max == 0) {
			System.out.println(n-1);
			return;
		}
		
		if(n == 1) {
			cnt_n++;
			result = 1;
		} else {
			result = 1;
		}
	
		while(true) {
			if(cnt_n == max) { // 다친 손가락 최대 횟수 다 됐을 때 
				// 1에 있을 때는 dir=1이고 
				// 5에 있을 때는 dir=-1임. 
				if(n == 1 || n == 5) {
					result += 7;
				} else {
					if(dir == 1) {
						result += n-2;
					} else if(dir == -1) {
						result += 4-n;
					}
				}
				break;
			}
			
			if(dir == 1) { // 2 3 4 5
				result += 4;
				if(n != 1) cnt_n++;
			} else if(dir == -1) { // 4 3 2 1
				result += 4;
				if(n != 5) cnt_n++;
			}
			
			dir *= -1; // 방향 전환 
		}
		
		System.out.println(result);
	}
}
