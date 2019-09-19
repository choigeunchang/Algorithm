import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	
	static class Node{
		
		long x, y;
		int idx;
		public Node() {}
		public Node(long x, long y, int idx) {
			this.x = x;
			this.y = y;
			this.idx = idx;
		}
		@Override
		public String toString() {
			return idx + "번섬의 좌표: " + x + "," + y;
		}
	}
	
	static class Prim implements Comparable<Prim>{
		
		int des;
		double weight;
		
		public Prim(int idx, double weight) {
			this.des = idx;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Prim [idx=" + des + ", weight=" + weight + "]";
		}
		@Override
		public int compareTo(Prim o) {
			return Double.compare(o.weight, this.weight);
		}
	}

	static ArrayList<Prim>[] list;
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		for(int t=1; t<=test_case; t++) {
			// 섬의 갯수
			n = Integer.parseInt(bf.readLine());
			Node[] node = new Node[n];
			list = new ArrayList[n];
			for(int i=0; i<n; i++) {
				list[i] = new ArrayList<>();
			}
			// x좌표 입력
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for(int i=0; i<n; i++) {
				node[i] = new Node();
				node[i].x = Integer.parseInt(st.nextToken());
				node[i].idx = i;
			}
			// y좌표 입력
			str = bf.readLine();
			st = new StringTokenizer(str);
			for(int i=0; i<n; i++)
				node[i].y = Integer.parseInt(st.nextToken());
			// 세율 입력
			double tax = Double.parseDouble(bf.readLine());
//			
//			for(int i=0; i<n; i++)
//				System.out.println(node[i].toString());
			
			// 각 지점에 연결된 간선 만들기
			
			for(int i=0; i<n; i++) {
				
				for(int j=i+1; j<n; j++) {
					double len = (node[i].x - node[j].x)*(node[i].x - node[j].x) + (node[i].y - node[j].y)*(node[i].y - node[j].y);
					list[i].add(new Prim(j, len));
					list[j].add(new Prim(i, len));
				}
			}
//			System.out.println("Testcase: " + t);
//			print();
//			System.out.println();
			ArrayList<Integer> island = new ArrayList<>();
			boolean[] visited = new boolean[n];
			island.add(0);
			visited[0] = true;
			int count = 0;
			double total = 0;
			
			while(island.size() < n) {
				
				double min = Double.MAX_VALUE;
				for(int p : island) {
					
					for(int i=0; i<list[p].size(); i++) {
						
						Prim n = list[p].get(i);
						if(!visited[n.des] && min > n.weight) {
							min = n.weight;
							count = n.des;
						}
					}
				}
				visited[count] = true;
				island.add(count);
				total += min;
			}
			
			System.out.println("#" + t + " " + Math.round(total * tax));
		}
	}
	
	static void print() {
		
		for(int i=0; i<n; i++) {
			System.out.println(i+"번섬");
			for(int j=0; j<list[i].size(); j++)
				System.out.println(list[i].get(j).toString());
		}
	}
}
