package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 문자열_1516_단어세기_문자열비교 {
	public static class Word{
		String word;
		int cnt;
		
		public Word(String word, int cnt) {
			super();
			this.word = word;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String content;
		StringTokenizer st;
		String word; 
		boolean isExist = false; 
		
		ArrayList<Word> list;
		StringBuilder sb = new StringBuilder();

		while(!(content=br.readLine()).equals("END")) {
			list = new ArrayList<Word>();
			st = new StringTokenizer(content, " ");
			
			for(int i=0, size=st.countTokens(); i<size; i++) {
				word = st.nextToken();
				isExist = false;
				for(int j=0, size2=list.size(); j<size2; j++){
					if(list.get(j).word.equals(word)) {
						list.get(j).cnt++;
						isExist = true;
						break;
					}
				}
				if(!isExist) {
					list.add(new Word(word, 1));
				}
			}
			
			list.sort(new Comparator<Word>() {
				@Override
				public int compare(Word o1, Word o2) {
					return o1.word.compareTo(o2.word);
				}
			});
			
			for(int i=0, size=list.size(); i<size; i++) {
				sb.append(list.get(i).word).append(" : ").append(list.get(i).cnt).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
