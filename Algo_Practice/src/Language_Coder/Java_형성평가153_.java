package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_형성평가153_ {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[100];
		
//		입력받은 정수가 -1을 제외하고 3개 미만일 경우에는 -1을 제외하고 입력받은 정수를 모두 출력한다.
		int n;
		int last = -1;
		for(int i=0; i<100; i++) {
			n = Integer.parseInt(st.nextToken());
			if(n == -1) {
				last = i;
				arr[i] = -1;
				break;
			}
			arr[i] = n;
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(last < 3) {
			int i = 0;
			while(arr[i] != -1) {
				sb.append(arr[i++]).append(" ");
			}
		}
		else {
			for(int i=last-3; i<last; i++) {
				sb.append(arr[i]).append(" ");
			}			
		}
		
		System.out.println(sb.toString());
	}
}

