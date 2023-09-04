package 구현;

import java.util.*;
import java.io.*;

public class boj1013_contact_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++) {
			char[] str = br.readLine().toCharArray();
			// 10 또는 01 로 시작 
			// 10 이후 0이 나오면 괜찮, 1이 나와도 괜찮 
			// 1이 나온 이후 0이 나오면 01
			//			  또는 1 여러개면 100+1+
			int length = str.length; 
			int p = 0; 
			boolean result = true; 
			while(p < length) {
				System.out.println("p: " + p);
				if(str[p] == '0') { 
					p++;
					System.out.println("1");
					if(p == length) {
						System.out.println("2");
						result = false;
						break; 
					}
					// 01
					if(str[p] == '1'){
						p++;
						System.out.println("3");
					} else {
						System.out.println("4");
						// 틀림 
						result = false; 
						break;
					}
				} else if(str[p] == '1') {
					p++;
					System.out.println("5");
					if(p == length) {
						System.out.println("6");
						result = false;
						break; 
					}					
					// 100
					if(str[p] == '0') { 
						p++;
						System.out.println("7");

						if(p == length) { 
							System.out.println("8");
							result = false; 
							break; 
						}
						
						if(str[p] == '0') {
							p++;
							System.out.println("9");

							if(p == length) { 
								System.out.println("10");
								result = false; 
								break; 
							}

							while(str[p] == '0') {
								p++;
								System.out.println("11");

								if(p == length) { 
									System.out.println("12");
									result = false; 
									break; 
								}
							}
							System.out.println("13");

							// 다음이 1일 것 
							p++;
							
							if(p == length) {
								System.out.println("14");

//								// 틀림 
//								result = false;
								break;
							}
							
							boolean next1 = false; // 1이 2개 이상 연속될 때 
							while(p<length && str[p] == '1') {
								System.out.println("15");

								next1 = true; 
								p++;
							}
							
							// 1로 끝난 경우 
							if(p >= length-1) break; 
							System.out.println("16"); 
							
							// 다음 0이 나옴 
							if(str[p+1] == '0') { // 1다음이 00이면 
								System.out.println("17");

								if(next1) {
									System.out.println("18");

									p--;
								} else { 
									System.out.println("19");

									// 틀림 
									result = false;
									break;
								}
							} else { // 1다음이 01이면 
								System.out.println("20");

								p += 2;
							}
						} else {
							System.out.println("21");

							// 틀림 
							result = false; 
							break;
						}
					} else {
						System.out.println("22");

						// 틀림 
						result = false; 
						break;
					}
				}
				System.out.println();
			}
			
			sb.append(result ? "YES\n" : "NO\n");
		}
		System.out.println(sb.toString());
	}
}
