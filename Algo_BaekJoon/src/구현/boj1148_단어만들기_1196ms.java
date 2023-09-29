package 구현;

import java.util.*;
import java.io.*;

public class boj1148_단어만들기_1196ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<char[]> words = new ArrayList<>(); // 단어 개수 1~200000
		String str = br.readLine();
		while(!str.equals("-")) {
			words.add(str.toCharArray());
			str = br.readLine();
		}
		
		if(!str.equals("#")) str = br.readLine();
		StringBuilder sb = new StringBuilder();

		while(!str.equals("#")) { // 모든 퍼즐판에 대해서 
			Map<Integer, ArrayList<Character>> result = new HashMap<>();
			char[] puzzle = str.toCharArray(); // 퍼즐판 
			
			ArrayList<Character> center = new ArrayList<>(); // 정중앙에 놓였던 문자들 
			for(int i=0; i<puzzle.length; i++) { // puzzle에 있는 알파벳이 정중앙에 오는 모든 경우의 수 
				int temp_result = 0; // 현재 결과 
				char center_alpha = puzzle[i]; // 꼭 들어가야되는 알파벳 
				if(center.contains(center_alpha)) continue; // 이미 정중앙 알파벳으로 쓴 경우 
				center.add(center_alpha); 
				
				for(char[] word : words) {
					// 단어에 문자가 들어가는지 확인 
					boolean hasCenter = false; 
					for(int j=0; j<word.length; j++) {
						if(word[j] == center_alpha) {
							hasCenter = true; 
							break;
						}
					}
					
					if(!hasCenter) continue; 
					
					// 글자와 비교
					boolean[] visited = new boolean[puzzle.length];
					boolean hasWord = true; 
					for(int w=0; w<word.length; w++) { // 단어 한글자씩 있는지 확인 
						boolean hasAlpha = false; 
						for(int p=0; p<puzzle.length; p++) {
							if(visited[p]) continue; // 이미 사용한 알파벳이면 
							if(puzzle[p] == word[w]) { // 존재하면 
								visited[p] = true; 
								hasAlpha = true; 
								break;
							}
						}
						if(!hasAlpha) { // 해당 알파벳이 존재하지 않으면  
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
