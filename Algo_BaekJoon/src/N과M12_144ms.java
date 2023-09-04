import java.util.*;
import java.io.*;

public class N과M12_144ms {
	static int M;
	static int size; 
	static Integer[] nums;
	static int[] result;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1~8
		M = Integer.parseInt(st.nextToken()); // 1~8

		Set<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		nums = set.toArray(new Integer[0]);
		Arrays.sort(nums);
		
		size = set.size();
		
		result = new int[M];
		sb = new StringBuilder();
		
		calc(0, 0);
		System.out.println(sb.toString());
	}
	
	public static void calc(int idx, int n) {
		if(idx == M) {
			for(int i=0; i<M; i++) {
				sb.append(nums[result[i]]).append(" ");
			}
			sb.append("\n");
			return; 
		}
		
		for(int i=n; i<size; i++) {
			result[idx] = i;
			calc(idx+1, i);
		}
	}
}
