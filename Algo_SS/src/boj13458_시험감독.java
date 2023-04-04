import java.util.*;
import java.io.*; 

public class boj13458_시험감독 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 시험장의 개수 1~1000000
		int[] A = new int[N]; // 시험장 별 응시자 수 1~1000000
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken()); // 총감독관이 감시할 수 있는 응시자 수 1~1000000
		int C = Integer.parseInt(st.nextToken()); // 부감독관이 감시할 수 있는 응시자 수 1~1000000
		long cnt = 0;

		for(int i=0; i<N; i++) {
			cnt++; 
			A[i] -= B;
			if(A[i] < 0) continue;
			if(A[i]%C == 0) {
				cnt += A[i]/C;
			} else {
				cnt += A[i]/C+1;
			}
		}
		
		System.out.println(cnt);
	}
}
