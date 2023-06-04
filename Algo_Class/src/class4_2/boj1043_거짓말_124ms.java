package class4_2;

import java.util.*;
import java.io.*; 

public class boj1043_거짓말_124ms{
	static int[] parents; 
	
	public static void main(String[] args) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 int N = Integer.parseInt(st.nextToken()); // 사람 수 1~50
		 int M = Integer.parseInt(st.nextToken()); // 파티 수 1~50 
		 
		 st = new StringTokenizer(br.readLine()); 
		 
		 int n = Integer.parseInt(st.nextToken());
		 int[] truth = new int[n]; // 진실을 아는 사람 
		 for(int i=0; i<n; i++) {
			 truth[i] = Integer.parseInt(st.nextToken());
		 }
		 
		 parents = new int[N+1];
		 for(int i=1; i<=N; i++) {
			 parents[i] = i;
		 }
		 
		 ArrayList<Integer>[] party_pnum = new ArrayList[M];
		 for(int i=0; i<M; i++) {
			 party_pnum[i] = new ArrayList<Integer>();
		 }
		 
		 // 파티 관계 따지기 
		 for(int i=0; i<M; i++) { // 파티 
			 st = new StringTokenizer(br.readLine());
			 int cnt = Integer.parseInt(st.nextToken()); // 파티 사람 수 
			 for(int j=0; j<cnt; j++) {
				 party_pnum[i].add(Integer.parseInt(st.nextToken()));
			 }
			 
			 int parent = find(party_pnum[i].get(0)); // 첫번째 parent 
			 
			 for(int j=1; j<cnt; j++) {
				 int p = find(party_pnum[i].get(j));
				 if(parent != p) {
					 union(party_pnum[i].get(0), party_pnum[i].get(j));
				 }
			 }
		 }
		 
		 int result = 0; 
		 
		 // 거짓말 칠 수 있는 파티 수 구하기 
		 for(int i=0; i<M; i++) { // 파티 
			 boolean canLie = true; 
			 for(int p : party_pnum[i]) { // 파티 사람 
				 for(int t : truth) { // 진실을 아는 사람 
					 if(find(t) == find(p)) {
						 canLie = false; 
						 break; 
					 }
				 }
				 if(!canLie) break; 
			 }
			 if(canLie) result++;
		 }
		 
		 System.out.println(result);
	 }
	 
	 public static void union(int n1, int n2) {
		 int n1_p = find(n1);
		 int n2_p = find(n2);
		 
		 if(n1_p != n2_p) parents[n1_p] = n2_p;
	 }
	 
	 public static int find(int n) {
		 if(n == parents[n]) return n; 
		 
		 return parents[n] = find(parents[n]);
	 }
}
