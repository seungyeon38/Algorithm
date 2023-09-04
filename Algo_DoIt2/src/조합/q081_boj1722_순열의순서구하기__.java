package 조합;

import java.util.*;
import java.io.*;

public class q081_boj1722_순열의순서구하기__ {
	static long[] factorial;
	static int N; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 1~20
		
		factorial = new long[N+1];
		factorial[0] = 1;
		for(int i=1; i<=N; i++) {
			factorial[i] = factorial[i-1]*i;
		}
		
		String str;
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		while(!(str = br.readLine()).equals("eof")) {
			st = new StringTokenizer(str);
			int type = Integer.parseInt(st.nextToken());
						
			if(type == 1) { // k번째 수열 구하기 
				int[] num = getPermu(Integer.parseInt(st.nextToken()));
				for(int i=0; i<N; i++) {
					sb.append(num[i]).append(" ");
				}
				sb.append("\n");
			} else if(type == 2) { // 몇 번째 수열인지
				int[] num = new int[N];
				for(int i=0; i<N; i++) {
					num[i] = Integer.parseInt(st.nextToken());
				}
				sb.append(getOrder(num)).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static int[] getPermu(int k) {
		//  k번째 수열
		int[] num = new int[N];
		boolean[] visited = new boolean[N+1];
		for(int i=N; i>0; i--) { // 자리수 
			System.out.println("수열: " + Arrays.toString(num));
			int temp = 1;
			while(k >= factorial[i-1]) {
//				System.out.println(temp + ", " + k + ", " + factorial[i-1]);
				if(visited[temp]){
//					System.out.println("1");
					temp++;
					continue;
				}
//				System.out.println("2");
				k -= factorial[i-1];
				temp++;
			}
			System.out.println(temp);
			num[N-i] = temp;
			visited[temp] = true; 
		}
		
		return num;
	}
	
	public static long getOrder(int[] arr) {
		long result = 1; 
		boolean[] visited = new boolean[N+1];
		for(int i=0; i<N; i++) { // 자리수 
			for(int j=1; j<arr[i]; j++) { // 그 자리의 숫자 
				if(visited[j]) continue;
				result += factorial[N-i-1];
			}
			visited[arr[i]] = true; 
		}
		
		return result;
	}
}
