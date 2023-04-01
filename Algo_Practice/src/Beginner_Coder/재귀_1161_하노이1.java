package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 재귀_1161_하노이1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		hanoi(N, 1, 2, 3);
	}
	
	public static void hanoi(int num, int from, int by, int to) {
		if(num == 1) {
			print(num, from, to);
			return;
		}
		
		hanoi(num-1, from, to, by);
		print(num, from, to);
		hanoi(num-1, by, from, to);
	}
	
	public static void print(int num, int from, int to) {
		System.out.println(num + " : " + from + " -> " + to);
	}
}
