import java.util.*;
import java.io.*;

public class N과M4_172ms {
	static int N, M;
	static int[] result;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 1~8
		M = Integer.parseInt(st.nextToken()); // 1~8
		
		result = new int[M];
		sb = new StringBuilder();
		
		calc(0, 1);
		System.out.println(sb.toString());
	}
	
	public static void calc(int idx, int n) {
		if(idx == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return; 
		}
		
		for(int i=n; i<=N; i++) {
			result[idx] = i;
			calc(idx+1, i);
		}
	}
}
