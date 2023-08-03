package 그리디;

import java.util.*;
import java.io.*;

public class boj1541_잃어버린괄호_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 괄호를 쳐서 식의 값을 최소로 
		ArrayList<Character> op = new ArrayList<>(); // 부호 
		ArrayList<Integer> nums = new ArrayList<>(); // 수  
		
		String[] str_list = br.readLine().split("-");
		String[] num_list = str_list[0].split("\\+");
		
		int result = 0;
		for(String num : num_list) {
			result += Integer.parseInt(num);
		}
		
		for(int i=1; i<str_list.length; i++) {
			num_list = str_list[i].split("\\+");
			
			int sum = 0;
			for(String num : num_list) {
				sum += Integer.parseInt(num);
			}
			
			result -= sum;
		}
		
		System.out.println(result);
	}
}
