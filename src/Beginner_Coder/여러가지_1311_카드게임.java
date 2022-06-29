package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여러가지_1311_카드게임 {
//	public static class Card{
//		char color;
//		int num;
//		
//		public Card(char color, int num) {
//			this.color = color;
//			this.num = num;
//		}
//	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
//		Card[] card_list = new Card[5];
//		
//		for(int i=0; i<5; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			card_list[i] = new Card(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
//		}
		
		int[] num = new int[10];
		int[] color = new int[4]; // R, B, Y, G
		
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			switch(st.nextToken().charAt(0)) {
			case 'R':
				color[0]++;
				break;
			case 'B':
				color[1]++;
				break;
			case 'Y':
				color[2]++;
				break;
			case 'G':
				color[3]++;
				break;
			}
			
			num[Integer.parseInt(st.nextToken())]++;
		}
		
		// 카드 5장이 모두 같은 색, 숫자가 연속적 
		boolean result = false; 
		int score = 0;
		int n = 0;
		for(int i=0; i<4; i++) {
			if(color[i] == 5) {
				for(int j=1; j<10; j++) {
					if(num[j] == 1) {
						n++;
						score = j;
						if(n == 5) break;
					} else {
						n = 0;
					}
				}
				if(n == 5) {
					result = true;
				}
				break; 
			}
		}
		if(result) {
			score += 900;
		}
		// 4장의 숫자가 같음 
		else {
			for(int i=1; i<10; i++) {
				if(num[i] == 4) {
					score = i+800;
					result = true; 
					break; 
				}
			}
			if(!result) { // 3장의 숫자가 같고 나머지 2장도 숫자가 같음 
				boolean n_2 = false; 
				boolean n_3 = false; 
				int n2 = 0;
				int n3 = 0;
				for(int i=1; i<10; i++) {
					if(num[i] == 2) {
						n_2 = true; 
						n2 = i;
					} else if(num[i] == 3) {
						n_3 = true; 
						n3 = i;
					}
					if(n_2 && n_3) {
						score = n3*10 + n2 + 700;
						result = true; 
						break; 
					}
				}
				
				if(!result) { // 5장의 카드 색깔이 모두 같음 
					for(int i=0; i<4; i++) {
						if(color[i] == 5) {
							for(int j=9; j>-1; j--) {
								if(num[j] != 0) {
									score = j+600;
									result = true; 
									break; 
								}
							}
						}
						if(result) break; 
					}
					
					if(!result) { // 5장의 숫자가 연속적임 
						n = 0;
						for(int j=1; j<10; j++) {
							if(num[j] == 1) {
								n++;
								score = j;
								if(n == 5) break;
							} else {
								n = 0;
							}
						}
						if(n == 5) {
							score += 500;
							result = true;
						}
						
						if(!result) { // 3장의 숫자가 같을 때 
							for(int i=1; i<10; i++) {
								if(num[i] == 3) {
									score = i+400;
									result = true; 
									break;
								}
							}
							
							if(!result) { // 2장의 숫자가 같고, 또 다른 2장의 숫자가 같을 때 
								int num1 = 0; 
								int num2 = 0;
								int cnt = 0;
								for(int i=1; i<10; i++) {
									if(num[i] == 2) {
										cnt++;
										if(num1 == 0) num1 = i;
										else num2 = i;
									}
								}
								if(cnt == 2) {
									score = num2*10 + num1 + 300;
									result = true; 
								}
								
								if(!result) { // 2장의 숫자가 같을 때 
									for(int i=1; i<10; i++) {
										if(num[i] == 2) {
											score = i+200;
											result = true; 
											break;
										}
									}
									if(!result){ // 어떤 경우에도 해당하지 않을 때 
										for(int i=9; i>-1; i--) {
											if(num[i] != 0) {
												score = i+100;
												break;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(score);
	}
}
