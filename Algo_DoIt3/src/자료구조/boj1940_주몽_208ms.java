package 자료구조;

import java.util.*;
import java.io.*;

public class boj1940_주몽_208ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 재료의 개수 1~15000
		int M = Integer.parseInt(br.readLine()); // 갑옷을 만드는데 필요한 수 1~10000000
		
		int[] ingredients = new int[N]; // 재료들이 가진 고유한 번호들 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			ingredients[i] = Integer.parseInt(st.nextToken()); // ~100000
		}
	
		Arrays.sort(ingredients);
		
		// 두 재료의 고유한 번호를 합쳐서 M이 되면 갑옷을 만듦 
		int sp = 0; 
		int ep = N-1;
		int result = 0; 
		
		while(sp < ep) {
			int temp_sum = ingredients[sp]+ingredients[ep];
			
			if(temp_sum < M) {
				sp++;
			} else if(temp_sum > M) {
				ep--;
			} else {
				result++;
				sp++;
				ep--;
			}
		}
		
		System.out.println(result);
	}
}
