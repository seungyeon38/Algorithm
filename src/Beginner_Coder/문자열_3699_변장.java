package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 문자열_3699_변장 {
	public static class Cloth{
		String kind;
		int cnt;
		
		public Cloth(String kind, int cnt) {
			super();
			this.kind = kind;
			this.cnt = cnt;
		} 
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		int N;
		ArrayList<Cloth> list;
		StringTokenizer st;
		String kind;
		boolean isExist; 
		
		StringBuilder sb = new StringBuilder();
		int result;
		for(int tc=0; tc<TC; tc++) {
			list = new ArrayList<Cloth>();
			N = Integer.parseInt(br.readLine());
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				kind = st.nextToken();
				isExist = false; 
				for(int j=0, size=list.size(); j<size; j++) {
					if(list.get(j).kind.equals(kind)) {
						list.get(j).cnt++;
						isExist = true; 
					}
				}
				if(!isExist) list.add(new Cloth(kind, 1));
			}
			
			result = 1;
			for(int i=0, size=list.size(); i<size; i++) {
				result *= (list.get(i).cnt+1);
			}
			result -= 1;
			
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
}
