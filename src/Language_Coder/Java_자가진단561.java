package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_자가진단561 {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		100 미만의 수 중 가장 큰 수와 100 이상의 수 중 가장 작은 수를 출력
//		만약 해당하는 수가 없을 때에는 100을 출력
		
		int max = 0;
		int min = 10000;
		int n;
		for(int i=0; i<10; i++) {
			n = Integer.parseInt(st.nextToken());
			if(n < 100) {
				max = Math.max(max, n);
			} else {
				min = Math.min(min, n);
			}
		}
		if(max == 0) max = 100;
		if(min == 10000) min = 100;
		System.out.println(max + " " + min);
	}
}