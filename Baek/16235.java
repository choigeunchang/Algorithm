package edu.ssafy.c1017;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나무재테크 {

	// 나무의 위치 및 나이
	static class Point implements Comparable<Point>{
	
		int x, y;
		int age;
		
		public Point() {}
		public Point(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
		@Override
		public int compareTo(Point o) {
			if(this.age > o.age)
				return 1;
			else if(this.age < o.age)
				return -1;
			else
				return 0;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", age=" + age + "]";
		}
	}
	
	static int n, m, k;
	static int[][] food;
	static PriorityQueue<Point> queue;
	static Queue<Point> live;
	static Queue<Point> dead;
	static Queue<Point> temp;
	static int[][] add;
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        food = new int[n+1][n+1];		// 매년 추가되는 양분의 양
        add = new int[n+1][n+1];
        
        queue = new PriorityQueue<>();
        live = new LinkedList<>();
        dead = new LinkedList<>();
        temp = new LinkedList<>();
        
        // 양분 현황판
        for(int i=1; i<=n; i++) {
        	st = new StringTokenizer(bf.readLine());
        	for(int j=1; j<=n; j++)
        		add[i][j] = Integer.parseInt(st.nextToken());
        }
        // 처음에 전부 5
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=n; j++)
        		food[i][j] = 5;
        }
        
        // 나무현황판
        for(int i=0; i<m; i++) {
        	
        	st = new StringTokenizer(bf.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int age = Integer.parseInt(st.nextToken());
        	queue.add(new Point(x, y, age));
        }
        
        // 1년마다 봄, 여름, 가을, 겨울 전부 1번씩 수행
        // 이를 k번만큼 수행하였을 때 남은 나무의 갯수
        /*
         * 봄: 어린 나무부터 자신의 나이만큼 먹고 1증가
         * 여름: 봄에 죽은 나무가 나이/2 만큼 양분 추가
         * 가을: 5의 배수인 나무 주변 8방에 나이 1 나무 생성
         * 겨울: 추가되는 양분의 양(food(r,c)
         */
        
        for(int i=0; i<k; i++) {
        	
        	spring();
        	summer();
        	fall();
        	winter();
        }
        
        int result = queue.size();
        
        bw.write(result + "\n");
        bw.flush();
        bw.close();
	}
	
	static void winter() {
	
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++)
				food[i][j] += add[i][j];
		}
	}

	static void fall() {
		
		while(!live.isEmpty()) {
			
			Point p = live.poll();
			temp.add(p);
			for(int i=0; i<8; i++) {
				
				int x = p.x + dr[i];
				int y = p.y + dc[i];
				if(range(x, y) && p.age % 5 == 0) {
					queue.add(new Point(x, y, 1));
				}
			}
		}
		
		while(!temp.isEmpty()) {
			
			Point p = temp.poll();
			queue.add(p);
		}
	}
	
	static void summer() {
		
		while(!dead.isEmpty()) {
			
			Point p = dead.poll();
			food[p.x][p.y] += (p.age/2);
		}
	}
	
	static void spring() {
		
		while(!queue.isEmpty()) {
			
			Point p = queue.poll();
//			System.out.println("봄나무: " + p.toString() + " -- " + food[p.x][p.y]);
			if(food[p.x][p.y] < p.age)				
				dead.add(new Point(p.x, p.y, p.age));
			else {
				food[p.x][p.y] -= p.age;
				live.add(new Point(p.x, p.y, p.age+1));		// 죽지 않는 나무들 저장
			}
		}
	}

	static void print(int[][] arr) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
	
	static boolean range(int x, int y) {
		return x>=1 && y>=1 && x<=n && y<=n;
	}
}

