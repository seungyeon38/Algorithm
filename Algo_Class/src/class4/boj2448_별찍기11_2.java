package class4;

import java.util.*;
import java.io.*;

public class boj2448_별찍기11_2 {
	static int N;
	static char[][] grid; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 3*2k(0~10)
		
		grid = new char[N][2*N-1];
		
//				(0,2)
//			(1,1)	(1,3)
//		(2,0)	1,2,3	(2,4)
		
		
		
//				(0,5)
//			(1,4)	(1,6)
//		(2,3)	4,5,6	(2,7)
		
//		(3,2)			(3,8)

		for(int n=0; n<N; n++) {
			
		}
	}
	
	public static void draw(int n) {
		if(n%3 == 0) {
			
		}
	}
}
