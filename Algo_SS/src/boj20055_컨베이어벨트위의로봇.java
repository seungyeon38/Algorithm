import java.util.*;
import java.io.*;

public class boj20055_컨베이어벨트위의로봇 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int N = Integer.parseInt(st.nextToken()); // 컨베이어벨트 길이 2~100
		int K = Integer.parseInt(st.nextToken()); // 1~2N
		
		int[] durability = new int[2*N]; // 내구도
		st = new StringTokenizer(br.readLine());
		
		int cnt_0 = 0;

		for(int i=0, size=2*N; i<size; i++) {
			durability[i] = Integer.parseInt(st.nextToken()); // 1~1000
			if(durability[i] == 0) cnt_0++;
		}
		
		boolean[] robot_loc = new boolean[N];
		int level = 0; 
		
		while(cnt_0 < K) {
			level++;
//			System.out.println(level + ": " + Arrays.toString(durability));
//			System.out.println(Arrays.toString(robot_loc));
			// 1. 벨트가 로봇과 함께 한칸 회전 
			// 벨트 한칸 회전 
			int temp = durability[2*N-1];
			for(int i=2*N-2; i>=0; i--) {
				durability[i+1] = durability[i];
			}
			durability[0] = temp;
			
			// 로봇 회전 
			for(int i=N-2; i>=0; i--) {
				robot_loc[i+1] = robot_loc[i];
			}
			robot_loc[0] = false; 
			if(robot_loc[N-1]) robot_loc[N-1] = false; // 내리는 위치 
			
			// 2. 가장 먼저 벨트에 올라간 로봇부터 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동, 만약 이동할 수 없다면 가만히 있기 
			for(int i=N-2; i>=0; i--) {
				if(robot_loc[i]) { // 로봇이 자리에 존재할 때 
					if(!robot_loc[i+1] && durability[i+1]>0) { // 이동할 수 있는 조건을 만족하면 
						// 이동 
						robot_loc[i+1] = true; 
						robot_loc[i] = false; 
						durability[i+1]--;
						if(durability[i+1] == 0) cnt_0++;
					}
				}
			}
			
			if(robot_loc[N-1]) robot_loc[N-1] = false; // 내리는 위치 
			
			// 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다. 
			if(durability[0] > 0) {
				robot_loc[0] = true; 
				durability[0]--;
				if(durability[0] == 0) cnt_0++;
			}
		}
		
		System.out.println(level);
	}
}
