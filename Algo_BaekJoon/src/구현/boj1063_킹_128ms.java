package 구현;

import java.util.*;
import java.io.*;

public class boj1063_킹_128ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		char[] king = st.nextToken().toCharArray(); // 킹 위치 
		int[] king_loc = new int[2];
		king_loc[1] = king[0]-'A';
		king_loc[0] = 8-(king[1]-'0');
		
		char[] stone = st.nextToken().toCharArray(); // 돌 위치
		int[] stone_loc = new int[2]; 
		stone_loc[1] = stone[0]-'A';
		stone_loc[0] = 8-(stone[1]-'0');

		int N = Integer.parseInt(st.nextToken()); // 움직이는 횟수 1~50 
		
		// 킹의 마지막 위치, 돌의 마지막 위치 구하기 
		
		for(int i=0; i<N; i++) {
			String move = br.readLine();
			
			int move_r = 0;
			int move_c = 0;
			
			switch(move) {
			case "R": // 한칸 오른쪽 
				move_c = 1; 
				break;
			case "L": // 한칸 왼쪽 
				move_c = -1; 
				break;
			case "B": // 한칸 아래로 
				move_r = 1;
				break;
			case "T": // 한칸 위로 
				move_r = -1; 
				break;
			case "RT": // 오른쪽 위 대각선으로 
				move_r = -1; 
				move_c = 1;
				break;
			case "LT": // 왼쪽 위 대각선으로 
				move_r = -1; 
				move_c = -1; 
				break;
			case "RB": // 오른쪽 아래 대각선으로 
				move_r = 1; 
				move_c = 1;
				break;
			case "LB": // 왼쪽 아래 대각선으로 
				move_r = 1; 
				move_c = -1; 
				break;
			}
			
			int nr = king_loc[0]+move_r;
			int nc = king_loc[1]+move_c;
			
			if(nr<0 || nr>7 || nc<0 || nc>7) continue; 
			if(stone_loc[0] == nr && stone_loc[1] == nc) { // 돌 위치로 이동해야되면 
				int nr2 = stone_loc[0]+move_r;
				int nc2 = stone_loc[1]+move_c;
				
				if(nr2<0 || nr2>7 || nc2<0 || nc2>7) continue; 
				stone_loc[0] = nr2; 
				stone_loc[1] = nc2; 
			}
			
			king_loc[0] = nr;
			king_loc[1] = nc;
		}
		
		// 변환 
		System.out.println(change(king_loc[0], king_loc[1]));
		System.out.println(change(stone_loc[0], stone_loc[1]));
	}
	
	public static String change(int r, int c) {
		char alpha = (char)('A'+c);
		int n = 8-r;

		return String.valueOf(alpha)+String.valueOf(n);
	}
}
