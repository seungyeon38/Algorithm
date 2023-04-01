package Algorithm;

import java.io.*;

public class q006_boj2018 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int sp = 1;
		int fp = 1;
		
		int result = 1;
		int sum = 1;
		
		while(fp != N) {
			if(sum > N) { 
				sum -= sp; // sp 빼기 
				sp++; // sp를 한칸 앞으로
			} else if(sum == N) {
				result++; // 결과+1
				fp++; // fp를 한칸 앞으로 
				sum += fp;
			} else {
				fp++; // fp를 한칸 앞으로 
				sum += fp; 
			}
		}
		
		System.out.println(result);
	}
}
