import java.util.*;
import java.io.*;

public class codetree_싸움땅_2022하반기 {
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int n, m, k;
	static ArrayList<Integer>[][] guns; 
	static Player[] players;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		n = Integer.parseInt(st.nextToken()); // 격자 크기 2~20
		m = Integer.parseInt(st.nextToken()); // 플레이어 수 1~400
		k = Integer.parseInt(st.nextToken()); // 라운드 수 1~500
		guns = new ArrayList[n][n]; // 총 정보 배열 
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				guns[i][j] = new ArrayList<Integer>();
			}
		}
		
		players = new Player[m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				guns[i][j].add(Integer.parseInt(st.nextToken())); // 1~100000
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			players[i] = new Player(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
		}
		
		int[] point = new int[m];
		
		for(int i=0; i<k; i++) {
			for(int p=0; p<m; p++) {
				Player player = players[p];
				// 첫 번째 플레이어부터 순차적으로 본인이 향하고 있는 방향대로 한 칸만큼 이동
				// 만약 해당 방향으로 나갈 때 격자를 벗어나는 경우에는 정반대 방향으로 방향을 바꾸어서 1만큼 이동
				move(p);
				
				int loc_player = getPlayer(p); // 이동한 방향에 있는 플레이어 
				if(loc_player == -1) { // 이동한 방향에 플레이어가 없다면, 해당 칸에 총이 있는지 확인
					// 총 있는지 확인 
					if(!guns[player.x][player.y].isEmpty()) { // 총이 있는 경우, 해당 플레이어는 총을 획득
						// 플레이어가 이미 총을 가지고 있는 경우에는 놓여있는 총들과 플레이어가 가지고 있는 총 가운데 공격력이 더 쎈 총을 획득
						// 나머지 총들은 해당 격자에 둔다. 
						getGun(player);
					}
				} else { // 이동한 방향에 플레이어가 있는 경우, 두 플레이어가 싸우게 됨. 
					Player player2 = players[loc_player]; // 이동한 방향에 있는 플레이어 
					
					// 해당 플레이어의 초기 능력치와 가지고 있는 총의 공격력의 합을 비교
					int skill1 = player.s + player.gun;
					int skill2 = player2.s + player2.gun;
					int winner_n = -1; 
					int loser_n = -1; 
					
					if(skill1 < skill2) { // player2가 이김
						winner_n = loc_player;
						loser_n = p;
					} else if(skill1 > skill2) { // player가 이김 
						winner_n = p;
						loser_n = loc_player;
					} else { // 비김: 플레이어의 초기 능력치가 높은 플레이어가 승리
						if(player.s < player2.s) { // player2가 이김
							winner_n = loc_player;
							loser_n = p;
						} else {
							winner_n = p;
							loser_n = loc_player;
						}
					}
					
					int diff = Math.abs(skill1-skill2);
					point[winner_n] += diff;
					
					moveLoser(loser_n);
					getGun(players[winner_n]);
				}
			}		
		}

		StringBuilder sb = new StringBuilder();
		for(int i : point) {
			sb.append(i).append(" ");
		}
		System.out.println(sb.toString()); 
	}
	
	public static class Player{
		int x; 
		int y;
		int d; // 방향 
		int s; // 초기 능력치 
		int gun; // 가지고 있는 총 
		
		Player(int x, int y, int d, int s, int gun){
			this.x = x;
			this.y = y;
			this.d = d;
			this.s = s;
			this.gun = gun; 
		}
	}
	
	public static boolean out(int r, int c) {
		if(r<0 || r>=n || c<0 || c>=n) {
			return true;
		}
		
		return false; 
	}
	
	// 순차적으로 본인이 향하고 있는 방향대로 한 칸만큼 이동
	public static void move(int player_n) {
		Player player = players[player_n];

		int nr = player.x + dir[player.d][0];
		int nc = player.y + dir[player.d][1];
		
		// 격자를 벗어나는 경우에는 정반대 방향으로 방향을 바꾸어서 1만큼 이동
		if(out(nr, nc)) { // 방향 바꾸기 
			player.d = (player.d+2)%4;
			
			nr = player.x + dir[player.d][0];
			nc = player.y + dir[player.d][1];
		}
		
		player.x = nr; 
		player.y = nc; 
	}
	
	// 자리에 player가 있는지 (없으면 -1)
	public static int getPlayer(int player_n) {
		for(int i=0; i<m; i++) {
			if(i != player_n) {
				if(players[player_n].x == players[i].x && players[player_n].y == players[i].y) {
					return i;
				}
			}
		}
		return -1; 
	}
	
	// 자리에 player가 있는지 (없으면 -1)
	public static boolean getPlayer(int r, int c, int player_n) {
		for(int i=0; i<m; i++) {
			if(i != player_n) {
				if(players[i].x == r && players[i].y == c) {
					return true;
				}
			}
		}
		return false; 
	}
	
	// 진 플레이어는 본인이 가지고 있는 총을 해당 격자에 내려놓고, 해당 플레이어가 원래 가지고 있던 방향대로 한 칸 이동
	// 이동하려는 칸에 다른 플레이어가 있거나 격자 범위 밖인 경우에는 오른쪽으로 90도씩 회전하여 빈 칸이 보이는 순간 이동
	// 만약 해당 칸에 총이 있다면, 해당 플레이어는 가장 공격력이 높은 총을 획득하고 나머지 총들은 해당 격자에 내려 놓는다.
	public static void moveLoser(int player_n) {
		Player player = players[player_n];
		if(player.gun != 0) {
			guns[player.x][player.y].add(player.gun);
			player.gun = 0;
		}
		
		int nr = player.x + dir[player.d][0];
		int nc = player.y + dir[player.d][1];
		
		// 이동하려는 칸에 다른 플레이어가 있거나 격자 범위 밖인 경우
		while(getPlayer(nr, nc, player_n) || out(nr, nc)) {
			player.d = (player.d+1)%4; // 오른쪽으로 90도씩 회전
			nr = player.x + dir[player.d][0];
			nc = player.y + dir[player.d][1];
		}
		
		// 빈칸이 보이는 순간 이동 
		player.x = nr;
		player.y = nc; 
		
		// 만약 해당 칸에 총이 있다면, 해당 플레이어는 가장 공격력이 높은 총을 획득하고 나머지 총들은 해당 격자에 내려 놓는다.
		getGun(player);
	}
	
	public static void getGun(Player p) {
		int max = 0; 
		int max_idx = -1;
		
		for(int i=0; i<guns[p.x][p.y].size(); i++) {
			if(guns[p.x][p.y].get(i) > max) {
				max = guns[p.x][p.y].get(i);
				max_idx = i;
			};
		}
		
		if(p.gun == 0 && max_idx != -1) { // 가지고 있는 총이 없을 때 
			p.gun = max;
			guns[p.x][p.y].remove(max_idx);
		} else { // 가지고 있는 총이 있다면 
			if(p.gun < max) { // 가지고 있는 총보다 더 쎈 총이 있다면 
				int temp = p.gun; 
				p.gun = max; 
				guns[p.x][p.y].remove(max_idx);
				guns[p.x][p.y].add(temp);
			}
		}
	}
}
