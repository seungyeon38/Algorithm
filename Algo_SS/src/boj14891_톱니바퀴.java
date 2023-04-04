import java.util.*;
import java.io.*;

public class boj14891_톱니바퀴 {
	static char[][] gears; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		gears = new char[5][];
		for(int i=1; i<=4; i++) {
			gears[i] = br.readLine().toCharArray();
		}
		
		int K = Integer.parseInt(br.readLine()); // 회전 횟수 (1~100)
		
		for(int i=0; i<K; i++) {
//			for(int j=1; j<5; j++) {
//				System.out.println(Arrays.toString(gears[j]));
//			}
//			System.out.println();
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			int gear_n = Integer.parseInt(st.nextToken()); 
			int dir = Integer.parseInt(st.nextToken()); // 1: 시계, -1: 반시계 
			int temp_left_gear = gear_n;
			int temp_right_gear = gear_n;
			boolean[] rotate = new boolean[5]; // 회전시킬 기어 
			rotate[gear_n] = true; 
			
			while(temp_left_gear>1 && gears[temp_left_gear][6]!=gears[temp_left_gear-1][2]) {
				rotate[--temp_left_gear] = true;
			}
			
			while(temp_right_gear<4 && gears[temp_right_gear][2]!=gears[temp_right_gear+1][6]) {
				rotate[++temp_right_gear] = true;
			}
			
//			System.out.println(Arrays.toString(rotate));
			
			for(int n=1; n<5; n++) {
				if(rotate[n]) {
					if(Math.abs(gear_n-n)%2 == 0) {
						rotate(n, dir);
					} else {
						rotate(n, dir*(-1));
					}
				}
			}
		}
		
		int result = 0; 
		for(int i=1; i<5; i++) {
			if(gears[i][0] == '1') {
				int temp = 1;
				for(int j=1; j<i; j++) {
					temp *= 2;
				}
				result += temp;
			}
		}
		
		System.out.println(result);
		// 1번 기어: 2
		// 2번 기어: 2, 6
		// 3번 기어: 2, 6
		// 4번 기어: 6
	}
	
	public static void rotate(int gear_n, int dir) {
		if(dir == 1) { // 시계 방향 
			char temp = gears[gear_n][7]; 
			for(int i=6; i>=0; i--) {
				gears[gear_n][i+1] =  gears[gear_n][i];
			}
			 gears[gear_n][0] = temp;
		} else { // 반시계 방향 
			char temp = gears[gear_n][0]; 
			for(int i=1; i<8; i++) {
				gears[gear_n][i-1] =  gears[gear_n][i];
			}
			 gears[gear_n][7] = temp;
		}
	}
}
