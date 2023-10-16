package 구현;

import java.util.*;
import java.io.*;

public class boj1680_쓰레기수거_156ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			int W = Integer.parseInt(st.nextToken()); // 쓰레기차 용량 1~1000
			int N = Integer.parseInt(st.nextToken()); // 지점의 개수 1~1000
			Trash[] trash_list = new Trash[N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()); // 쓰레기장으로부터의 거리 0~100000 
				int w = Integer.parseInt(st.nextToken()); // 쓰레기 양 1~W
				
				trash_list[i] = new Trash(x, w);
			}
			
			int cur_w = 0;
			int cur_loc = 0;
			int result = 0;
			for(int i=0; i<N; i++) {
				Trash trash = trash_list[i];
				result += trash.loc-cur_loc;
				cur_loc = trash.loc;

				// 2. 그 지점의 쓰레기를 실었을 때 쓰레기차의 용량을 넘게 될 때
				if(cur_w+trash.trash > W) {
					i--;
					result += trash.loc*2;
					cur_w = 0;
				} else if(i != N-1 && cur_w+trash.trash == W){ // 쓰레기 양이 용량에 도달했을 때 
					result += trash.loc*2;
					cur_w = 0;
				} else { // 용량이 넘지 않을 때 
					cur_w += trash.trash;
				}
			}
			
			sb.append(result+trash_list[N-1].loc).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static class Trash{
		int loc;
		int trash;
		
		Trash(int loc, int trash){
			this.loc = loc;
			this.trash = trash;
		}
	}
}
