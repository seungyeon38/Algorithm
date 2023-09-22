package 구현;

import java.util.*;
import java.io.*; 

public class boj1337_올바른배열_128ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 배열의 크기 1~50
		ArrayList<Integer> nums = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			nums.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(nums);
		int result = 4; 
		
		for(int i=0; i<N; i++) {
			int temp_cnt = 0;
			for(int j=1; j<5; j++) {
				if(!nums.contains(nums.get(i)+j)) {
					temp_cnt++;
				}
			}
			if(result > temp_cnt) result = temp_cnt;
		}
		
		System.out.println(result);
	}
}
