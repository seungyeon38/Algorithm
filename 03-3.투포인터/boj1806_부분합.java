import java.util.*;
import java.io.*;

public class boj1806 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 100000
		int S = Integer.parseInt(st.nextToken()); // 100000000
				
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			arr[i] = n; 
		}
		
		int p1 = 0; 
		int p2 = 0; 
		long sum = 0; 
		int result = 100001; 
		
		while(true) {
			if(sum >= S) {
				sum -= arr[p1];
				result = Math.min(result, p2-p1);
				p1++;
			} else if(p2 == N){
				break;
			} else {
				sum += arr[p2];
				p2++;
			}
		}
		
		if(result == 100001) System.out.println("0");
		else System.out.println(result);
	}
}
