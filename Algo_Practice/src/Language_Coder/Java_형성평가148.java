package Language_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_형성평가148 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
//		#		1 4
//		# #		2 2
//		# # #	3 0
//		  # #	2 2
//		    #	4 1
		int temp;
		for(int i=1, size=2*n-1; i<=size; i++) {
			if(i<=n) {
				for(int j=0; j<i; j++) {
					sb.append("#").append(" ");
				}
			}
			else {
				temp = i-n;
				for(int j=0, size2=temp*2; j<size2; j++) {
					sb.append(" ");
				}
				for(int j=n-temp; j>0; j--) {
					sb.append("#").append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

