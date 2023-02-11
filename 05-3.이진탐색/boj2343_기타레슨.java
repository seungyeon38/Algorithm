import java.util.*;
import java.io.*;

public class boj2343_기타레슨 {
	static int N, M; 
	static int[] lectures;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 강의 수 100000
		M = Integer.parseInt(st.nextToken()); // 블루레이 수 
		
		st = new StringTokenizer(br.readLine());
		lectures = new int[N];
		int sum = 0;
		int max = 0;
		
		for(int i=0; i<N; i++) {
			lectures[i] = Integer.parseInt(st.nextToken());
			sum += lectures[i];
			max = Math.max(max, lectures[i]);
		}
		
		// 블루레이 크기 최소 max, 최대 sum
		int start = max;
		int end = sum;
		int result = 0;
		while(start <= end) {
			int mid = (start+end)/2;
			
			int temp_result = check(mid);
			if(temp_result == 0) { // 크기가 작을 때 
				start = mid+1;
			} else if(temp_result == 1) {
				result = mid;
				end = mid-1;
			}
		}
		
		if(result != 0) System.out.println(result);
	}
	
	public static int check(int size) {
		int temp_cnt = 1; 
		int temp_sum = 0;
		// 블루레이 크기가 size일 때, 가능한지 여부 
		for(int i=0; i<N; i++) {
			temp_sum += lectures[i];
			if(temp_sum > size) {
				temp_cnt++;
				temp_sum = lectures[i];
			}
		}
		
		if(temp_cnt > M) { // 개수가 더 많으면 -> 크기가 작다는 말 
			return 0;
		} else {
			return 1;
		}
	}
}
