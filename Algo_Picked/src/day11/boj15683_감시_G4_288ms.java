package day11;

import java.util.*;
import java.io.*; 

public class boj15683_감시_G4_288ms {
	static int[] d_cnt = {0, 4, 2, 4, 4, 1}; // cctv 타입별 방향 개수 
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int N, M;
	static int[][] office;
	static int[][] temp;
	static ArrayList<Cctv> cctv_list;
	static int min_cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 1~8
		M = Integer.parseInt(st.nextToken()); // 1~8
		
		office = new int[N][M];
		cctv_list = new ArrayList<Cctv>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if(office[i][j] >= 1 && office[i][j] <= 5) {
					cctv_list.add(new Cctv(i, j, office[i][j]));
				}
			}
		}
		
		// 0은 빈 칸, 6은 벽, 1~5는 CCTV
		// CCTV의 최대 개수는 8개
		
		temp = new int[N][M]; // 개수 
		min_cnt = Integer.MAX_VALUE;
		calc(0);
		
		System.out.println(min_cnt);
		
	}
	
	public static void calc(int idx) { 
		if(idx == cctv_list.size()) {
			// cnt 세기
			int cnt = 0;

			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(temp[i][j]==0 && office[i][j]==0) cnt++;
				}
			}
			if(min_cnt > cnt) min_cnt = cnt; 
			
			return; 
		}
		
		Cctv cctv = cctv_list.get(idx);
		
		for(int d=0, size=d_cnt[cctv.type]; d<size; d++) {
			watch(cctv, d);
			calc(idx+1);
			unwatch(cctv, d); // 원래대로 돌아가야함. 
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
	
//	public static 
	
	public static void watch(Cctv cctv, int d) {
		switch(cctv.type) {
		case 1: 
			watch1(cctv, d);
			break;
		case 2:
			watch2(cctv, d);
			break; 
		case 3:
			watch3(cctv, d);
			break;
		case 4:
			watch4(cctv, d);
			break; 
		case 5:
			watch5(cctv);
			break; 
		}
	}
	
	public static void unwatch(Cctv cctv, int d) {
		switch(cctv.type) {
		case 1: 
			unwatch1(cctv, d);
			break;
		case 2:
			unwatch2(cctv, d);
			break; 
		case 3:
			unwatch3(cctv, d);
			break;
		case 4:
			unwatch4(cctv, d);
			break; 
		case 5:
			unwatch5(cctv);
			break; 
		}
	}
	
	public static boolean isOut(int r, int c) {
		if(r<0 || r>=N || c<0 || c>=M) return true; 
		return false; 
	}
	
	// 한 쪽 방향만 감시
	public static void watch1(Cctv cctv, int d) {
		// 0: 위, 1: 우, 2: 아래, 3:좌 
		int nr = cctv.r + dir[d][0];
		int nc = cctv.c + dir[d][1];
		while(!(isOut(nr, nc) || office[nr][nc]==6)) { // 밖으로 나가는 경우나 벽인 경우를 제외 
			temp[nr][nc]++;
			
			nr += dir[d][0];
			nc += dir[d][1];
		}
	}
	public static void unwatch1(Cctv cctv, int d) {
		int nr = cctv.r + dir[d][0];
		int nc = cctv.c + dir[d][1];
		while(!(isOut(nr, nc) || office[nr][nc]==6)) { // 밖으로 나가는 경우나 벽인 경우를 제외 
			temp[nr][nc]--;
			
			nr += dir[d][0];
			nc += dir[d][1];
		}
	}
	
	// 두 방향을 감시, 감시하는 방향이 서로 반대방향
	public static void watch2(Cctv cctv, int d) {
		// 0: 상하(0, 2), 1: 좌우(1, 3)
		int nr = cctv.r + dir[d][0]; 
		int nc = cctv.c + dir[d][1];
		while(!(isOut(nr, nc) || office[nr][nc]==6)) {
			temp[nr][nc]++;
			
			nr += dir[d][0];
			nc += dir[d][1];
		}
		d += 2;
		
		nr = cctv.r + dir[d][0];
		nc = cctv.c + dir[d][1];
		while(!(isOut(nr, nc) || office[nr][nc]==6)) {
			temp[nr][nc]++;
			
			nr += dir[d][0];
			nc += dir[d][1];
		}
	}
	public static void unwatch2(Cctv cctv, int d) {
		// 0: 상하(0, 2), 1: 좌우(1, 3)
		int nr = cctv.r + dir[d][0]; 
		int nc = cctv.c + dir[d][1];
		while(!(isOut(nr, nc) || office[nr][nc]==6)) {
			temp[nr][nc]--;
			
			nr += dir[d][0];
			nc += dir[d][1];
		}
		d += 2;
		
		nr = cctv.r + dir[d][0];
		nc = cctv.c + dir[d][1];
		while(!(isOut(nr, nc) || office[nr][nc]==6)) {
			temp[nr][nc]--;
			
			nr += dir[d][0];
			nc += dir[d][1];
		}
	}	
	
	// 두 방향을 감시, 직각 방향
	public static void watch3(Cctv cctv, int d) {
		// 0: 상,우, 1: 우,하, 2: 하,좌, 3: 좌,상
		int nr = cctv.r + dir[d][0]; 
		int nc = cctv.c + dir[d][1];
		while(!(isOut(nr, nc) || office[nr][nc]==6)) {
			temp[nr][nc]++;
			
			nr += dir[d][0];
			nc += dir[d][1];
		}
		d = (d+1)%4;
		
		nr = cctv.r + dir[d][0];
		nc = cctv.c + dir[d][1];
		while(!(isOut(nr, nc) || office[nr][nc]==6)) {
			temp[nr][nc]++;
			
			nr += dir[d][0];
			nc += dir[d][1];
		}
	}
	public static void unwatch3(Cctv cctv, int d) {
		// 0: 상,우, 1: 우,하, 2: 하,좌, 3: 좌,상
		int nr = cctv.r + dir[d][0]; 
		int nc = cctv.c + dir[d][1];
		while(!(isOut(nr, nc) || office[nr][nc]==6)) {
			temp[nr][nc]--;
			
			nr += dir[d][0];
			nc += dir[d][1];
		}
		d = (d+1)%4;
		
		nr = cctv.r + dir[d][0];
		nc = cctv.c + dir[d][1];
		while(!(isOut(nr, nc) || office[nr][nc]==6)) {
			temp[nr][nc]--;
			
			nr += dir[d][0];
			nc += dir[d][1];
		}
	}
	
	// 세 방향 감시 
	public static void watch4(Cctv cctv, int d) {
		// 0: 위, 1: 우, 2: 아래, 3:좌  제외 
		for(int i=0; i<4; i++) {
			if(i != d) {
				int nr = cctv.r + dir[i][0];
				int nc = cctv.c + dir[i][1];
				while(!(isOut(nr, nc) || office[nr][nc]==6)) {
					temp[nr][nc]++;
					
					nr += dir[i][0];
					nc += dir[i][1];
				}
			}
		}
	}
	public static void unwatch4(Cctv cctv, int d) {
		// 0: 위, 1: 우, 2: 아래, 3:좌  제외 
		for(int i=0; i<4; i++) {
			if(i != d) {
				int nr = cctv.r + dir[i][0];
				int nc = cctv.c + dir[i][1];
				while(!(isOut(nr, nc) || office[nr][nc]==6)) {
					temp[nr][nc]--;
					
					nr += dir[i][0];
					nc += dir[i][1];
				}
			}
		}
	}
	
	// 네 방향 감시 
	public static void watch5(Cctv cctv) {
		for(int i=0; i<4; i++) {
			int nr = cctv.r + dir[i][0];
			int nc = cctv.c + dir[i][1];
			while(!(isOut(nr, nc) || office[nr][nc]==6)) {
				temp[nr][nc]++;
				
				nr += dir[i][0];
				nc += dir[i][1];
			}
		}
	}
	public static void unwatch5(Cctv cctv) {
		for(int i=0; i<4; i++) {
			int nr = cctv.r + dir[i][0];
			int nc = cctv.c + dir[i][1];
			while(!(isOut(nr, nc) || office[nr][nc]==6)) {
				temp[nr][nc]--;
				
				nr += dir[i][0];
				nc += dir[i][1];
			}
		}
	}
}
