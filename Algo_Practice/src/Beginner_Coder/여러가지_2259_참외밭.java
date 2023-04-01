package Beginner_Coder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여러가지_2259_참외밭 {
	public static class Line{
		int dir; 
		int length;
		
		public Line(int dir, int length) {
			super();
			this.dir = dir;
			this.length = length;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine()); 
		
		StringTokenizer st; 
		
		Line[] lines = new Line[6];
		
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int width_max = 0;
		int width_idx = 0; // 1,2
		int height_max = 0;
		int height_idx = 0; // 3,4
		
		for(int i=0; i<6; i++) {
			if((lines[i].dir==1 || lines[i].dir==2) && width_max<lines[i].length) {
				width_max = lines[i].length;
				width_idx = i;
			} else if((lines[i].dir==3 || lines[i].dir==4) && height_max<lines[i].length) {
				height_max = lines[i].length;
				height_idx = i;
			}
		}
		
		int left_width = Math.abs(lines[(height_idx+5)%6].length-lines[(height_idx+1)%6].length);
		int left_height = Math.abs(lines[(width_idx+5)%6].length-lines[(width_idx+1)%6].length);
		
		System.out.println((width_max*height_max - left_width*left_height)*K);
	}
}
