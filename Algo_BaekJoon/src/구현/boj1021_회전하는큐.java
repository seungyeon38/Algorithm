package 구현;

import java.util.*;
import java.io.*;

public class boj1021_회전하는큐 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 큐의 크기 1~50
		int M = Integer.parseInt(st.nextToken()); // 뽑아내려고 하는 수 1~N
		
		int[] nums = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
	}
}
