package 구현;

import java.util.*;
import java.io.*;

public class boj1283_단축키지정_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 옵션의 개수 1~30
		
		// 알파벳 첫글자 
		// 단어 첫글자 
		// 왼쪽에서부터 
		// 대소문자 구분 X 
		
		ArrayList<Character> c_list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			String[] option = br.readLine().split(" "); // 옵션 
			
			// 단어의 첫 글자로 단축키 
			StringBuilder temp = new StringBuilder();
			boolean find = false; 
			
			for(String word : option) {
				char[] chars = word.toCharArray();

				// 아직 단축키 지정이 안됐고, 알파벳이 단축키로 아직 지정이 안된 경우 
				if(!find && !c_list.contains(Character.toLowerCase(chars[0]))) {
					temp.append("[").append(chars[0]).append("]");
					for(int w=1; w<chars.length; w++) {
						temp.append(chars[w]);
					}
					find = true; 
					c_list.add(Character.toLowerCase(chars[0]));
				} else {
					temp.append(word);
				}
				
				temp.append(" ");
			}
			
			if(find) sb.append(temp.toString());
			else {
				// 왼쪽에서부터 차례대로 
				temp = new StringBuilder();
				for(String word : option) {
					char[] chars = word.toCharArray();
					
					for(char c : chars) {
						if(!find && !c_list.contains(Character.toLowerCase(c))) {
							temp.append("[").append(c).append("]");
							c_list.add(Character.toLowerCase(c));
							find = true; 
						} else {
							temp.append(c);
						}
					}
					
					temp.append(" ");
				}
				
				sb.append(temp);
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
