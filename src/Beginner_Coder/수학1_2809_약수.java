package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class 수학1_2809_약수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 2 ≤ N ≤ 21억
		
		int sqrt = (int)Math.sqrt(N);
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i=1; i<=sqrt; i++) {
			if(N%i == 0) {
				arr.add(i);
				
				if(N/i != i) {
					arr.add(N/i);
				}
			}
		}
		
		arr.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0, size=arr.size(); i<size; i++) {
			sb.append(arr.get(i)).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
