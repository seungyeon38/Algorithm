package class5_2;

import java.util.*;
import java.io.*;

public class boj27172_수나누기게임_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 플레이어의 수 
		int[] cards = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		// 서로의 카드를 보여줌 
		// 상대방의 수가 자신의 수로 나누어떨어지면 승 
		// 자신의 수가 상대방의 수로 나누어떨어지면 패 
		// 아니면 무승부 
		
		// 모든 플레이어의 점수 구하기 
		
		
	}
}
