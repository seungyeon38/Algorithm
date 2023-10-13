import java.util.*;
import java.io.*;

public class boj15683_감시_576ms_ {
	static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 우, 하, 좌, 상 
	static int N, M;
	static int[][] office;
	static ArrayList<Cctv> cctv_list;
	static int[] cctv_dir;
	static int cctv_list_length;
	static int min = 100;
	static int[][] temp_office;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 사각지대의 최소 크기 구하기
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로 크기 1~8
		M = Integer.parseInt(st.nextToken()); // 가로 크기 1~8
		office = new int[N][M];
		cctv_list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if(office[i][j]>=1 && office[i][j]<=5) {
					cctv_list.add(new Cctv(i, j, office[i][j]));
				}
			}
		}
		
		cctv_list_length = cctv_list.size();
		cctv_dir = new int[cctv_list_length];
				
		permu(0);
		System.out.println(min);
	}
	
	public static void permu(int idx) {
		if(idx == cctv_list_length) {
			// 계산 
			temp_office = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					temp_office[i][j] = office[i][j];
				}
			}
			
			for(int i=0; i<cctv_list_length; i++) {
				watchCctv(cctv_list.get(i), cctv_dir[i]);
			}
			
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(temp_office[i][j] == 0) cnt++;
				}
			}
			
			min = Math.min(min, cnt);
			
			return; 
		}
		
		for(int d=0; d<4; d++) {
			cctv_dir[idx] = d;
			permu(idx+1);
		}
	}
	
	public static void watchCctv(Cctv cctv, int d) {
		switch(cctv.type) {
		case 1:
			if(d == 0) {
				watch(cctv.r, cctv.c, 3);
			} else if(d == 1) {
				watch(cctv.r, cctv.c, 0);
			} else if(d == 2) {
				watch(cctv.r, cctv.c, 1);
			} else if(d == 3) {
				watch(cctv.r, cctv.c, 2);
			}
			break;
		case 2:
			if(d==0 || d==2) { // 위아래 
				watch(cctv.r, cctv.c, 1);
				watch(cctv.r, cctv.c, 3);
			} else { // 양옆 
				watch(cctv.r, cctv.c, 0);
				watch(cctv.r, cctv.c, 2);
			}
			break;
		case 3:
			if(d == 0) { // 상, 우 
				watch(cctv.r, cctv.c, 3);
				watch(cctv.r, cctv.c, 0);
			} else if(d == 1) { // 우, 하 
				watch(cctv.r, cctv.c, 0);
				watch(cctv.r, cctv.c, 1);
			} else if(d == 2) { // 하, 좌 
				watch(cctv.r, cctv.c, 1);
				watch(cctv.r, cctv.c, 2);
			} else if(d == 3) { // 좌, 상 
				watch(cctv.r, cctv.c, 2);
				watch(cctv.r, cctv.c, 3);
			}
			break;
		case 4:
			if(d == 0) { // 좌, 상, 우  
				watch(cctv.r, cctv.c, 2);
				watch(cctv.r, cctv.c, 3);
				watch(cctv.r, cctv.c, 0);
			} else if(d == 1) { // 상, 우, 하 
				watch(cctv.r, cctv.c, 3);
				watch(cctv.r, cctv.c, 0);
				watch(cctv.r, cctv.c, 1);
			} else if(d == 2) { // 우, 하, 좌 
				watch(cctv.r, cctv.c, 0);
				watch(cctv.r, cctv.c, 1);
				watch(cctv.r, cctv.c, 2);
			} else if(d == 3) { // 하, 좌, 상 
				watch(cctv.r, cctv.c, 1);
				watch(cctv.r, cctv.c, 2);
				watch(cctv.r, cctv.c, 3);
			}
			break;
		case 5:
			watch(cctv.r, cctv.c, 0);
			watch(cctv.r, cctv.c, 1);
			watch(cctv.r, cctv.c, 2);
			watch(cctv.r, cctv.c, 3);
			break;
		}
	}
	
	public static void watch(int sr, int sc, int d) {
		int nr = sr;
		int nc = sc;
		while(true) {
			nr += dir[d][0];
			nc += dir[d][1];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M) break;
			if(temp_office[nr][nc] == 6) break;
			
			if(temp_office[nr][nc] == 0) temp_office[nr][nc] = -1;
		}
	}
	
	public static class Cctv{
		int r; 
		int c;
		int type;
		
		Cctv(int r, int c, int type){
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}
}
