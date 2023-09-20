package 구현;

import java.util.*;
import java.io.*;

public class boj1308_DDay_148ms {
	static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t_year = Integer.parseInt(st.nextToken());
		int t_month = Integer.parseInt(st.nextToken());
		int t_day = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int d_year = Integer.parseInt(st.nextToken());
		int d_month = Integer.parseInt(st.nextToken());
		int d_day = Integer.parseInt(st.nextToken());
		
		if(d_year-t_year>1000 || (d_year-t_year==1000 && (d_month>t_month || (d_month==t_month && d_day>=t_day)))) {
			System.out.println("gg");
			return; 
		}
		
		int t_cnt = getDays(t_year, t_month, t_day);
		int d_cnt = getDays(d_year, d_month, d_day);
		
		System.out.println("D-" + (d_cnt-t_cnt));
	}
	
	public static int getDays(int y, int m, int d) {
		int result = 0; 
		
		for(int i=1; i<y; i++) {
			if(isLeap(i)) result += 366;
			else result += 365;
		}
		
		boolean isLeap = isLeap(y);
		for(int i=1; i<m; i++) {
			if(isLeap && i==2) result += 29;
			else {
				result += days[i];
			}
		}
		
		result += d;
		
		return result;
	}
	
	public static boolean isLeap(int year) {
		boolean result = false; 
		
		if(year%4 == 0) {
			result = true;
			if(year%100 == 0) {
				result = false; 
				if(year%400 == 0) {
					result = true; 
				}
			}
		}
		
		return result;
	}
}
