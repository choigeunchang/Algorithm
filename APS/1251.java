import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Node{
	
	long x, y;

	public Node() {}
	public Node(long x, long y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return x + ", " + y;
	}
}

class Cost implements Comparable<Cost>{

	int idx;
	double levy;
	
	public Cost() {}
	public Cost(int idx, double levy) {
		this.idx = idx;
		this.levy = levy;
	}

	@Override
	public int compareTo(Cost o) {
		if(o.levy < this.levy)
			return 1;
		else if(o.levy == this.levy)
			return 0;
		else
			return -1;
	}
}

public class Solution {

	// 우선순위 큐: 우선순위의 기준을 거리로 한다면, 크루스칼과 비슷하다
	static PriorityQueue<Cost> queue;
	static double tax;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			int n = Integer.parseInt(bf.readLine());		// 섬의 갯수
			queue = new PriorityQueue<>();
			Node[] node = new Node[n];						// 섬의 좌표 담을 객체
			
			String[] xtr = bf.readLine().split(" ");
			String[] ytr = bf.readLine().split(" ");
			for(int i=0; i<n; i++)
				node[i] = new Node(Integer.parseInt(xtr[i]), Integer.parseInt(ytr[i]));
			tax = Double.parseDouble(bf.readLine());		// 세율
			
			long temp = 0;									// 세전 금액
			int count = 0;									// 방문 횟수
			boolean[] visited = new boolean[n];
			queue.offer(new Cost(0, 0));					// 반복 돌리기 위해 초기값 넣어줌
			while(!queue.isEmpty() && count<node.length) {
				
				Cost cost = queue.poll();					// 들어온 순서 상관없이 우선순위가 높은 것부터 추출
//				System.out.println(count + "번째 뽑아낸 levy: " + cost.levy);
				if(!visited[cost.idx]) {					// 해당 idx번 섬 방문 체크
					
					visited[cost.idx] = true;	// 첫 방문 후 true 변경
					temp += cost.levy;
//					System.out.println("더해진 levy: " + temp);
					count++;
					
					for(int i=0; i<node.length; i++) {		// 매번 섬 전체를 방문 체크하면서 방문안한것만 우선순위큐에 담아 추출 
						
						long x1 = node[i].x;
						long x2 = node[cost.idx].x;
						long y1 = node[i].y;
						long y2 = node[cost.idx].y;
						
						if(!visited[i]) {
//							System.out.println(x1 + "," + y1 + "\t" + x2 + "," + y2);
							queue.offer(new Cost(i, (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)));		// 두 섬간 거리 저장 (터널 길이의 제곱)
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + Math.round(temp * tax));
		}
	}	
}
