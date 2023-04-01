package 자료구조;

import java.util.*;
import java.io.*;

public class q007_boj1940_주몽의명령 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 재료의 개수 1~15000
		int M = Integer.parseInt(br.readLine()); // 갑옷을 만드는데 필요한 수 1~10000000
		
		int[] ingredients = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			ingredients[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(ingredients);
		
		int p1 = 0; 
		int p2 = N-1; 
		int result = 0;
		
		while(p1 < p2) {
			int sum = ingredients[p1]+ingredients[p2];
			
			if(sum == M) {
				result++; 
				p1++;
				p2--;
			} else if(sum < M) {
				p1++;
			} else {
				p2--;
			}
		}
		
		System.out.println(result);
	}
}
