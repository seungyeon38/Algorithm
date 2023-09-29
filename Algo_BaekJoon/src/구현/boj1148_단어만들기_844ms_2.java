package 구현;

import java.util.*;
import java.io.*;

public class boj1148_단어만들기_844ms_2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int alpha_n = 'Z'-'A'+1;
		int[][] word_cnt = new int[200000][alpha_n]; // 단어 개수 1~200000
		String str = br.readLine();
		int idx = 0;
		while(!str.equals("-")) {
			for(int i=0; i<str.length(); i++) {
				word_cnt[idx][str.charAt(i)-'A']++;
			}

			str = br.readLine();
			idx++;
		}
		
		if(!str.equals("#")) str = br.readLine();
		StringBuilder sb = new StringBuilder();

		while(!str.equals("#")) { // 모든 퍼즐판에 대해서 
			Map<Integer, ArrayList<Character>> result = new HashMap<>();
			char[] puzzle = str.toCharArray(); // 퍼즐판 
			
			ArrayList<Character> center = new ArrayList<>(); // 정중앙에 놓였던 문자들 
			int[] puzzle_cnt = new int[alpha_n]; 
			for(char c : puzzle) {
				puzzle_cnt[c-'A']++;
			}
			
			for(int i=0; i<puzzle.length; i++) { // puzzle에 있는 알파벳이 정중앙에 오는 모든 경우의 수 
				int temp_result = 0; // 현재 결과 
				char center_alpha = puzzle[i]; // 꼭 들어가야되는 알파벳 
				if(center.contains(center_alpha)) continue; // 이미 정중앙 알파벳으로 쓴 경우 
				center.add(center_alpha); 
				
				for(int j=0; j<idx; j++) {
					// 단어에 문자가 들어가는지 확인 
					boolean hasCenter = true; 
					if(word_cnt[j][center_alpha-'A'] == 0) {
						hasCenter = false; 
					}
					if(!hasCenter) continue;
					
					// 글자와 비교
					boolean hasWord = true; 

					for(int a=0; a<alpha_n; a++) {
						if(puzzle_cnt[a] < word_cnt[j][a]) {
							hasWord = false; 
							break;
						}
					}
					
					if(hasWord) temp_result++;
				}
				
				// 저장 
				ArrayList<Character> cur = result.getOrDefault(temp_result, new ArrayList<>());
				cur.add(center_alpha);
				result.put(temp_result, cur);
			}

			str = br.readLine();
			
			int max = 0;
			int min = 200001;
			
			for(int i : result.keySet()) {
				max = Math.max(max, i);
				min = Math.min(min, i);
			}
			
			ArrayList<Character> min_arr = result.get(min);
			ArrayList<Character> max_arr = result.get(max);
			Collections.sort(min_arr);
			Collections.sort(max_arr);
			
			for(Character c : min_arr) {
				sb.append(c);
			}
			sb.append(" ");
			sb.append(min);
			sb.append(" ");
			
			for(Character c : max_arr) {
				sb.append(c);
			}
			sb.append(" ");
			sb.append(max);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
