package Language_Coder;

import java.io.IOException;

public class Java_형성평가163 {
	public static void main(String[] args) throws IOException {	
		int[][] arr = {{3, 5, 9}, {2, 11, 5}, {8, 30, 10}, {22, 5, 1}};
		
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<3; j++) {
				sum += arr[i][j];
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.append(sum);
		
		System.out.println(sb.toString());
	}
}

