package 구현;

import java.util.*;
import java.io.*;

public class boj1340_연도진행바_124ms {
	static int[] month_day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] date = br.readLine().split(" ");
		
		int month = getMonth(date[0]);
		int day = Integer.parseInt(date[1].substring(0, date[1].length()-1));
		int year = Integer.parseInt(date[2]);
		String[] time = date[3].split(":");
		int hour = Integer.parseInt(time[0]);
		int minute = Integer.parseInt(time[1]);
		
		int total_m = 0;
		boolean isLeap = isLeapYear(year);
		
		if(isLeap) total_m = 366*24*60;
		else total_m = 365*24*60;
		
		int cur_m = 0;
		for(int i=0; i<month; i++) {
			cur_m += month_day[i];
			if(isLeap && i==1) cur_m++;
		}
		cur_m += day-1;
		cur_m *= 24;
		cur_m += hour;
		cur_m *= 60;
		cur_m += minute;
		
		System.out.println((double)cur_m/total_m*100);
	}
	
	public static boolean isLeapYear(int year) {
		boolean result = false; 
		
		if(year%4 == 0) {
			result = true; 
			if(year%100==0 && year%400!=0) {
				result = false; 
			}
		}
			
		return result;
	}
	
	public static int getMonth(String month) {
		switch(month) {
			case "January":
				return 0;
			case "February":
				return 1;
			case "March":
				return 2;
			case "April":
				return 3;
			case "May":
				return 4;
			case "June":
				return 5;
			case "July":
				return 6;
			case "August":
				return 7;
			case "September":
				return 8;
			case "October":
				return 9;
			case "November":
				return 10;
			case "December":
				return 11;
		}
			
		return -1;
	}
}
