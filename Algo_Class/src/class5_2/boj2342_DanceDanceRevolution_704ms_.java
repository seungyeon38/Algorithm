package class5_2;

import java.util.*;
import java.io.*;

public class boj2342_DanceDanceRevolution_704ms_ {
	static ArrayList<Integer> pos;
	static int[][][] result;
	
	public static void main(String[] args) throws Exception{
		// 두 발은 동시에 움직이지 않는다 
		// 두 발이 같은 지점에 있는 것이 허락되지 않는다 
		// 발이 움직이는 위치에 따라서 드는 힘이 다르다 
		// 중앙 -> 다른 지점 : 2 
		// 다른 지점 -> 인접한 지점 : 3
		// 다른 지점 -> 반대편 : 4
		// 같은 지점 : 1 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String order = st.nextToken();
		
		pos = new ArrayList<Integer>();
		while(!order.equals("0")) {
			pos.add(Integer.parseInt(order));
			order = st.nextToken();
		}
		
		result = new int[5][5][pos.size()]; // 왼발, 오른발, 순서 
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				Arrays.fill(result[i][j], -1);
			}
		}
		
		System.out.println(solve(0, 0, 0)); 
	}
	
	public static int solve(int left, int right, int dest) {
		if(dest == pos.size()) return 0; // 끝 
		
		if(result[left][right][dest] != -1) return result[left][right][dest];
		
		// 왼쪽을 움직일지, 오른쪽을 움직일지 
		result[left][right][dest] = Math.min(solve(pos.get(dest), right, dest+1)+getForce(left, pos.get(dest)), 
											solve(left, pos.get(dest), dest+1)+getForce(right, pos.get(dest)));
		
		return result[left][right][dest];
	}
	
	public static int getForce(int cur, int next) {
		if(cur == next) return 1; 
		else if(cur == 0) return 2;
		
		int diff = Math.abs(cur-next);
		if(diff == 1 || diff == 3) return 3;
		else if(diff == 2) return 4; 
		
		return -1; 
	}
}
