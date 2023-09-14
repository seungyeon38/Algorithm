package 구현;

import java.util.*;
import java.io.*;

public class boj1205_등수구하기_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 랭킹 리스트에 있는 점수 0~P
		int score = Integer.parseInt(st.nextToken()); // 태수 점수 0~2000000000
		int P = Integer.parseInt(st.nextToken()); // 랭킹 리스트에 올라갈 수 있는 점수 개수 10~50 
		
		// 태수 점수가 랭킹 리스트에서 몇 등 하는지 구하기 
		if(N == 0) {
			System.out.println("1");
			return; 
		}
		
		Stack<Integer> scores = new Stack<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			scores.add(Integer.parseInt(st.nextToken()));
		}
		
		int rank = N+1;
		while(!scores.isEmpty()) {
			if(scores.peek() < score) {
				rank--;
				scores.pop();
			} else if(scores.peek() == score) {
				if(rank > P) {
					break;
				} else {
					rank--;
					scores.pop();
				}
			} else break;
		}
		
		if(rank > P) {
			System.out.println("-1");
		} else {
			System.out.println(rank);
		}
	}
}
