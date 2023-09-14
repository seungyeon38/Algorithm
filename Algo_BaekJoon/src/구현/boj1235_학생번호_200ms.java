package 구현;

import java.util.*;
import java.io.*; 

public class boj1235_학생번호_200ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 학생 수 2~1000
		
		// 문자열 길이 1~100
		// 뒤에서 k자리만 남겨놓을 때 
		String[] nums = new String[N];
		for(int i=0; i<N; i++) {
			nums[i] = br.readLine();
		}
		int length = nums[0].length();
		int result = 0; 
		
		for(int i=1; i<=length; i++) { // 문자열 길이 
			ArrayList<String> list = new ArrayList<>();
			boolean done = true; 
			for(String str : nums) {
				String subString = str.substring(length-i);

				if(list.contains(subString)) {
					list.clear();
					done = false; 
				} else {
					list.add(subString);
				}
				
				if(!done) break; 
			}
			
			if(done) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}
}
