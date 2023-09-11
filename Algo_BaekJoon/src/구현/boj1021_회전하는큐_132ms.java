package 구현;

import java.util.*;
import java.io.*;

public class boj1021_회전하는큐_132ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 큐의 크기 1~50
		int M = Integer.parseInt(st.nextToken()); // 뽑아내려고 하는 수 1~N
		
		// 주어진 순서대로 뽑는데 이동해야하는 연산의 최솟값 구하기 
		
		int[] nums = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		LinkedList<Integer> num_list = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			num_list.add(i);
		}

		int cnt = 0;
		for(int i=0; i<M; i++) {
			int num = nums[i];
			int idx = num_list.indexOf(num);
			int mid = num_list.size()/2; 
			if(idx > mid) { // 오른쪽으로 이동 
				for(int j=0, size=num_list.size()-idx; j<size; j++) {
					int temp = num_list.pollLast();
					num_list.addFirst(temp);
					cnt++;
				}
			} else { // 왼쪽으로 이동 
				for(int j=0; j<idx; j++) {
					int temp = num_list.poll();
					num_list.add(temp);
					cnt++;
				}
			}
			num_list.poll();
		}
		
		System.out.println(cnt);
	}
}
