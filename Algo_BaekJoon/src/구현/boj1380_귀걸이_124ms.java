package 구현;

import java.util.*;
import java.io.*;

public class boj1380_귀걸이_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 귀걸이 압수 여학생 수 1~100
		int idx = 1;
		StringBuilder sb = new StringBuilder();
		
		while(n != 0) {
			String[] names = new String[n+1]; // 여학생들의 이름 
			for(int i=1; i<=n; i++) {
				names[i] = br.readLine();
			}
			
			boolean[] take = new boolean[n+1];
			for(int i=0, max=2*n-1; i<max; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
//				char alpha = st.nextToken().charAt(0);
				take[num] = !take[num];
			}
			
			sb.append(idx).append(" ");
			for(int i=1; i<=n; i++) {
				if(take[i]) {
					sb.append(names[i]).append(" ");
				}
			}
			
			sb.append("\n");
			n = Integer.parseInt(br.readLine());
			idx++;
		}
		
		System.out.println(sb.toString());
	}
}
