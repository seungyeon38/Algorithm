package class5_2;

import java.util.*;
import java.io.*;

public class boj2342_DanceDanceRevolution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> order = new ArrayList<Integer>(); // 지시 사항 
		int temp = Integer.parseInt(st.nextToken());
		while(temp != 0) {
			order.add(temp);
			temp = Integer.parseInt(st.nextToken());
		}
		
		int order_n = order.size();
		
	}
	
	// 같은 지점 : 1
	// 중앙 -> 다른 지점 : 2
	// 다른 지점 -> 인접한 지점 : 3
	// 반대편 지점 : 4
	// 중심 0 위 1 왼 2 아래 3 오 4
	public static int calc(int cur, int next) {
		if(cur == next) return 1;
		else if(cur == 0) return 2;
		else if(Math.abs(cur-next) == 2) return 4;
		else return 3;
	}
}
