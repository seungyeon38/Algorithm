package Algorithm;

import java.util.*;
import java.io.*;

public class q016_boj1377 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 500000
		
		Point[] arr = new Point[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = new Point(Integer.parseInt(br.readLine()), i);
		}
	
		Arrays.sort(arr);
		
		int max = 0; 
		for(int i=0; i<N; i++) {
			int n = arr[i].idx-i;
			
			if(n > max) {
				max = n;
			}
		}
		
		System.out.println(max+1);
	}
}

class Point implements Comparable<Point>{
	int num;
	int idx; 

	Point(int num, int idx){
		this.num = num; 
		this.idx = idx;
	}
	
	@Override
	public int compareTo(Point p) {
		return num - p.num;
	}
}
