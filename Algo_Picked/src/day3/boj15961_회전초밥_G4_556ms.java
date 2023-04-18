package day3;

import java.util.*;
import java.io.*;

public class boj15961_회전초밥_G4_556ms {
	static int N; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 벨트의 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공
		// 각 고객에게 초밥의 종류 하나가 쓰인 쿠폰을 발행
		// 이 쿠폰에 적혀진 종류의 초밥 하나를 추가로 무료로 제공
			// 만약 이 번호에 적혀진 초밥이 현재 벨트 위에 없을 경우, 요리사가 새로 만들어 손님에게 제공
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); // 회전 초밥 벨트에 놓인 접시의 수 2~3000000
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수 2~3000
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수 2~3000 
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호 1~d 
		
		int[] sushi = new int[N];
		for(int i=0; i<N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		// 위 할인 행사에 참여하여 가능한 한 다양한 종류의 초밥을 먹으려고 한다
		// 주어진 회전 초밥 벨트에서 먹을 수 있는 초밥의 가짓수의 최댓값
		int[] kind_cnt = new int[d+1];
		int max_cnt = 0;
		int cnt = 0;

		// 0 ~ k-1
		for(int i=0; i<k; i++) {
			if(kind_cnt[sushi[i]] == 0) cnt++;
			kind_cnt[sushi[i]]++;
		}
		
		if(kind_cnt[c] == 0) cnt++;
		kind_cnt[c]++;
		
		max_cnt = cnt; 
		
		for(int s=1; s<N; s++) {	
			int delete = sushi[s-1]; // 이전거 1개 지움
			kind_cnt[delete]--; // 개수-1 
			if(kind_cnt[delete] == 0) cnt--; // 0이 되면 종류 1개 적어진 것 
			
			int put = sushi[(s+k-1)%N]; // 다음거 1개 넣음 
			if(kind_cnt[put] == 0) cnt++; // 이전에 0이었으면 종류 1개 많아진 것 
			kind_cnt[put]++; // 개수+1			
			
			max_cnt = Math.max(max_cnt, cnt);
		}

		System.out.println(max_cnt);
	}
}
