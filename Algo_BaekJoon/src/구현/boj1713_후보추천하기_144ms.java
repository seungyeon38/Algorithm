package 구현;

import java.util.*;
import java.io.*;

public class boj1713_후보추천하기_144ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 사진틀의 개수 1~20 
		int recommend_cnt = Integer.parseInt(br.readLine()); // 전체 학생의 총 추천 횟수 ~1000
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Student> recommend_list = new ArrayList<>(); // 학생 번호, 추천 횟수 
				
		for(int i=0; i<recommend_cnt; i++) {
			int stu_n = Integer.parseInt(st.nextToken()); // 추천받은 학생 1~100
			
			int stu_idx = getStudentIdx(stu_n, recommend_list);
			if(stu_idx != -1) { // 현재 사진이 게시된 학생이 다른 학생의 추천을 받은 경우
				recommend_list.get(stu_idx).recommend_cnt++;
			} else if(recommend_list.size() == N) { // 비어있는 사진틀이 없는 경우
				Student stu = getPutIdx(recommend_list);
				stu.n = stu_n;
				stu.recommend_cnt = 1;
				stu.t = i;
			} else { 
				recommend_list.add(new Student(stu_n, 1, i));
			}
		}
		
		Collections.sort(recommend_list);
		StringBuilder sb = new StringBuilder();
		for(Student stu : recommend_list) {
			sb.append(stu.n).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	public static Student getPutIdx(ArrayList<Student> recommend_list) {
		Student result = recommend_list.get(0);
		for(int i=1, size=recommend_list.size(); i<size; i++) {
			Student stu = recommend_list.get(i);
			if(result.recommend_cnt > stu.recommend_cnt) {
				result = stu;
			} else if(result.recommend_cnt == stu.recommend_cnt && result.t>stu.t) {
				result = stu;
			}
		}
		
		return result;
	}
	
	public static int getStudentIdx(int stu_n, ArrayList<Student> recommend_list) {
		int result = -1;
		
		for(int i=0, size=recommend_list.size(); i<size; i++) {
			if(recommend_list.get(i).n == stu_n) {
				return i;
			}
		}
		
		return result; 
	}
	
	public static class Student implements Comparable<Student>{
		int n;
		int recommend_cnt;
		int t; // 게시된 시간 
		
		Student(int n, int recommend_cnt, int t){
			this.n = n;
			this.recommend_cnt = recommend_cnt;
			this.t = t;
		}
		
		@Override 
		public int compareTo(Student s) {
			return this.n - s.n;
		}
	}
}
