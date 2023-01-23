package Algorithm;

import java.util.*;
import java.io.*;

public class boj2251 {	
	static int[] size; // 물통 사이즈 
	static Queue<int[]> queue;
	static boolean[] result;
	static ArrayList<int[]> list = new ArrayList<>(); 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken()); // 200
		
		size = new int[]{A, B, C}; // 물통 사이즈 
		int[] quantity = new int[]{0, 0, C}; // 현재 물이 담겨 있는 양 
		
		result = new boolean[C+1];
		queue = new LinkedList<>();
		
		queue.offer(quantity);
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			if(temp[0] == 0) result[temp[2]] = true; // A가 비어있을 경우 
			
			// 옮길 수 있는 경우 따져서 옮기기 
			if(temp[0] != 0) {
				move(temp, 0, 1);
				move(temp, 0, 2);
			}
			
			if(temp[1] != 0) {
				move(temp, 1, 0);
				move(temp, 1, 2);
			}
			
			if(temp[2] != 0) {
				move(temp, 2, 0);
				move(temp, 2, 1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<=C; i++) {
			if(result[i]) sb.append(i).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void move(int[] cur_quan, int sp, int ep) { // 현재 양, 시작, 끝 
		int[] temp = Arrays.copyOf(cur_quan, cur_quan.length);

		if(cur_quan[sp]-(size[ep]-cur_quan[ep])>0) { // ep가 가득 찰 때까지 부음 
			temp[sp] -= size[ep] - cur_quan[ep];
			temp[ep] = size[ep];
		} else{	// sp에 물이 없어질 때까지 부음 
			temp[ep] += cur_quan[sp];
			temp[sp] = 0;
		}

		for(int[] arr: list) {
			if(arr[0]==temp[0] && arr[1]==temp[1] && arr[2]==temp[2]) {
				return;
			}
		}
		
		queue.offer(temp);
		list.add(temp);
	}
}
