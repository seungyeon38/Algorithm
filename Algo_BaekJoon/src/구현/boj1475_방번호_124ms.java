package 구현;

import java.util.*;
import java.io.*;

public class boj1475_방번호_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		char[] roomNum = br.readLine().toCharArray(); // 다솜이 방번호 1~1000000
		int[] cnt = new int[10];
		
		for(int i=0; i<roomNum.length; i++) {
			cnt[roomNum[i]-'0']++;
		}
		
		// 6, 9
		int mid = (cnt[6]+cnt[9])/2;
		if((cnt[6]+cnt[9])%2 == 0) {
			cnt[6] = mid;
			cnt[9] = mid;
		} else {
			cnt[6] = mid+1;
			cnt[9] = mid;
		}
		
		int result = 0;
		for(int i=0; i<10; i++) {
			result = Math.max(result, cnt[i]);
		}
		
		System.out.println(result);
	}
}
