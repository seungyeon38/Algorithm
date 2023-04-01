package Beginner_Coder;

import java.util.Scanner;

public class 수학2_1009_각자리수의역과합 {
	public static void main(String[] args) {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String s;
		int temp_sum;
		boolean invalid_zero;
		while(sc.hasNext()) {
			s = sc.next();
			char[] c_arr = s.toCharArray();
			
			temp_sum = 0;
			invalid_zero = true; // 
			for(int i=c_arr.length-1; i>-1; i--) {
				if(invalid_zero && c_arr[i]=='0') { // 유효하지 않은 0
//					System.out.println("아아");
				} else {
					invalid_zero = false;
					sb.append(c_arr[i]);
					temp_sum += c_arr[i]-'0';					
				}
			}
			if(temp_sum!=0) sb.append(" ").append(temp_sum);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
