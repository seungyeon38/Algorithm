package 자료구조;

import java.util.*;
import java.io.*;

public class boj3078_좋은친구_슬라이딩윈도우 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int N = Integer.parseInt(st.nextToken()); // 학생 수 3~300000
		int K = Integer.parseInt(st.nextToken()); // 등수 차이 1~N
		
		int[] name_length = new int[N]; // 이름 길이 저장 
		for(int i=0; i<N; i++) {
			name_length[i] = br.readLine().length();
		}
		
		int[] num = new int[21]; // 해당 길이의 이름 개수 저장 
		long result = 0;
		
		for(int i=0; i<K; i++) {
			result += num[name_length[i]]; // 좋은 친구 
			num[name_length[i]]++;
		}
		
		if(K < N) {
			result += num[name_length[K]]; // 좋은 친구 
			num[name_length[K]]++;
		}
		
		for(int i=K+1; i<N; i++) {
			num[name_length[i-K-1]]--; // 이전거 빼고 
			result += num[name_length[i]]; // 좋은 친구 
			num[name_length[i]]++; // 다음거 더하고 
		}
		
		System.out.println(result);
	}
}
