import java.util.*;
import java.io.*;

public class codetree_산타의선물공장2_2022하반기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int q = Integer.parseInt(br.readLine()); // 명령 수 1~100000
		
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
		Belt[] belts = null;
		Box[] boxes = null; 
		
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int m_src = -1; 
			int m_dst = -1; 
			switch(order) {
			case 100: // 공장 설립 
				int n = Integer.parseInt(st.nextToken()); // 벨트 2~100000
				int m = Integer.parseInt(st.nextToken()); // 선물 1~100000
				
				// 각각 선물의 번호는 오름차순으로 벨트에 쌓임 
				belts = new Belt[n+1];
				boxes = new Box[m+1];
				// 공장 설립 
				for(int box_n=1; box_n<=m; box_n++) {
					int belt_n = Integer.parseInt(st.nextToken()); // 선물이 올려질 벨트
					// 선물 만들기 
					// 해당 벨트가 비어있으면 이 선물이 head이자 tail 
					if(belts[belt_n] == null) {
						Belt belt = new Belt(1, box_n, box_n);
						belts[belt_n] = belt; 
						Box box = new Box(box_n, -1, -1); // 이전 박스, 다음 박스가 존재하지X
						boxes[box_n] = box;
					} else { // 해당 벨트가 비어있지 않으면 이 선물이 tail 
						Belt belt = belts[belt_n];
						belt.box_cnt++; // 박스 개수 하나 늘어남
						boxes[belt.tail].next = box_n; // 벨트 마지막 박스 뒤에 박스 생김 
						Box box = new Box(box_n, belt.tail, -1); // 벨트 맨 뒤에 박스 추가 
						boxes[box_n] = box; 
						belt.tail = box_n; // 벨트 맨 뒤 박스 업데이트 
					}
				}
				
				for(int belt_n=1; belt_n<=n; belt_n++) {
					if(belts[belt_n] == null) {
						Belt belt = new Belt(0, -1, -1);
						belts[belt_n] = belt; 
					}
				}

				break;
			case 200: // 물건 모두 옮기기 
				m_src = Integer.parseInt(st.nextToken()); // 이 벨트에 있는 박스들을 모두  
				m_dst = Integer.parseInt(st.nextToken()); // 이 벨트로 옮긴다 
				
				// m_src 벨트에 박스가 존재하는 경우 
				if(belts[m_src].box_cnt != 0) {
					Belt belt_src = belts[m_src];
					Belt belt_dst = belts[m_dst];

					// m_src의 tail에 있는 박스의 next을 m_dst의 head 박스로 업데이트 
					boxes[belt_src.tail].next = belt_dst.head;

					// m_dst 벨트의 head, box_cnt 업데이트 
					belt_dst.head = belt_src.head;
					belt_dst.box_cnt += belt_src.box_cnt;
							
					// m_src 벨트의 box_cnt, tail, head 업데이트 
					belt_src.box_cnt = 0;
					belt_src.tail = -1;
					belt_src.head = -1;
					
					sb.append(belt_dst.box_cnt).append("\n");
				}
				
				break;
			case 300: // 앞 물건만 교체하기 
				m_src = Integer.parseInt(st.nextToken()); // 이 벨트의 가장 앞에 있는 박스와   
				m_dst = Integer.parseInt(st.nextToken()); // 이 벨트의 가장 앞에 있는 박스를 교환 
				Belt belt_src = belts[m_src];
				Belt belt_dst = belts[m_dst];
				
				// 둘 중에 하나의 벨트에 존재하지 않으면 옮기기만 한다. 
				if(belt_src.box_cnt == 0 && belt_dst.box_cnt == 0) { // 둘 다 비어있는 경우 
					// 아무 일도 일어나지 않음 
				} else if(belt_src.box_cnt == 0) {
					// belt_dst의 첫번째 박스를 belt_src로 옮기기 
					// belt_src box_cnt, head, tail 모두 업데이트 
					belt_src.box_cnt++; 
					belt_src.head = belt_dst.head;
					belt_src.tail = belt_dst.head;
					
					Box box = boxes[belt_dst.head];
					// belt_dst의 box_cnt, head, tail 모두 업데이트 
					belt_dst.box_cnt--; 
					belt_dst.head = box.next;
					if(belt_dst.head == -1) belt_dst.tail = -1;
					
					// belt_dst 맨 앞에 있는 박스 정보 업데이트 : next 업데이트 
					// 그 다음 박스 정보 업데이트 : prev 업데이트 
					boxes[box.next].prev = -1;
					box.next = -1;
				} else if(belt_dst.box_cnt == 0) {
					// belt_src의 첫번째 박스를 belt_dst로 옮기기 
					// belt_dst box_cnt, head, tail 모두 업데이트 
					belt_dst.box_cnt++; 
					belt_dst.head = belt_src.head;
					belt_dst.tail = belt_src.head;
					
					Box box = boxes[belt_src.head];
					// belt_src의 box_cnt, head, tail 모두 업데이트 
					belt_src.box_cnt--; 
					belt_src.head = box.next;
					if(belt_src.head == -1) belt_src.tail = -1;
					
					// belt_src 맨 앞에 있는 박스 정보 업데이트 : next 업데이트 
					// 그 다음 박스 정보 업데이트 : prev 업데이트 
					boxes[box.next].prev = -1;
					box.next = -1;
				} else { // 앞에 두개 서로 바꾸기 
					// belt_src head, belt_dst head, 맨 앞 box, 그 다음 box 정보 업데이트 
					Box box_src = boxes[belt_src.head];
					Box box_dst = boxes[belt_dst.head];
					Box box_src_next = boxes[box_src.next];
					Box box_dst_next = boxes[box_dst.next];

					box_src.next = box_dst_next.n;
					box_dst.next = box_src_next.n;
					box_src_next.prev = box_dst.n;
					box_dst_next.prev = box_src.n;
							
					int temp = belt_src.head;
					belt_src.head = belt_dst.head;
					belt_dst.head = temp;
				}

				break;
			case 400: // 물건 나누기 
				
				
				break;
			case 500: // 선물 정보 얻기 
				break;
			case 600: // 벨트 정보 얻기 
				break;
			}
		}
	}
	
	public static class Box{
		int n; // 박스 번호 
		int prev; // 이전 박스 
		int next; // 다음 박스 
		
		Box(int n, int prev, int next){
			this.n = n; 
			this.prev = prev;
			this.next = next; 
		}
	}
	
	public static class Belt{
		int box_cnt; // 박스 개수 
		int head; // 맨 앞 박스 번호 
		int tail; // 맨 뒤 박스 번호 
		
		Belt(int box_cnt, int head, int tail){
			this.box_cnt = box_cnt; 
			this.head = head; 
			this.tail = tail; 
		}
	}
}
