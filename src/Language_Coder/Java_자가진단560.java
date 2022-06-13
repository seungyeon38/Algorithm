package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_자가진단560 {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<10; i++) {
			min = Math.min(min, Integer.parseInt(st.nextToken()));
		}
		
		System.out.println(min);
	}
}