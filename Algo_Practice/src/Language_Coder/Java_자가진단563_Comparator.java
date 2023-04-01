package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Java_자가진단563_Comparator {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		Integer[] arr = new Integer[10];
		
		for(int i=0; i<10; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1 > 0 ? 1 : -1;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<10; i++) {
			sb.append(arr[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}