package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 문자열_1535_단어집합2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word;
		ArrayList wordList = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		for(int i=0, size=st.countTokens(); i<size; i++) {
			wordList.add(st.nextToken());
		}
		sb.append(s).append("\n");
		
		Boolean hasWord = false; 
		while(!(s=br.readLine()).equals("END")) {
			st = new StringTokenizer(s, " ");
			
			for(int i=0, size=st.countTokens(); i<size; i++) {
				word = st.nextToken();
				hasWord = false; 
				
				for(int j=0, size2=wordList.size(); j<size2; j++) {
					if(wordList.get(j).equals(word)) {
						hasWord = true; 
						break;
					}					
				}
				
				if(!hasWord) {
					wordList.add(word);
				}
			}
			for(int i=0, size=wordList.size(); i<size; i++) {
				sb.append(wordList.get(i)).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
