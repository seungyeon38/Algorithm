package 구현;

import java.util.*;
import java.io.*;

public class boj1544_사이클단어_140ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 원형으로 써서 읽었을 때 같으면, 두 단어는 같은 단어 
		// 서로 다른 단어 구하기 
		
		int N = Integer.parseInt(br.readLine()); // 단어의 개수 1~50
		Set<String> words = new HashSet<>(); // 단어 (길이 1~50)
		int result = 0;
		for(int i=0; i<N; i++) {
			String word = br.readLine();
			
			if(!hasWord(words, word)) {
				result++;
				words.add(word);
			}
		}
		
		System.out.println(result);
	}
	
	public static boolean hasWord(Set words, String str2) {
		boolean result = false; 
		
		for(int i=0, length=str2.length(); i<length; i++) { // 시작점 
			String str = str2.substring(i)+str2.substring(0, i);

			if(words.contains(str)) {
				result = true;
				break;
			}
		}
	
		return result;
	}
}
