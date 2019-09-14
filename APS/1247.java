import java.io.*;
import java.util.*;

class Customer{
	
	int x;
	int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public Customer() {}
	public Customer(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
 
	static int min;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		for(int t=1; t<=test_case; t++) {
			
			int customer = Integer.parseInt(bf.readLine());
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			arr = new int[customer+2][2];
			
			int idx = 0;
			while(st.hasMoreTokens()) {
				arr[idx][0] = Integer.parseInt(st.nextToken());
				arr[idx][1] = Integer.parseInt(st.nextToken());
				idx++;
			}
			
			// 고객 배열 따로 관리
			Customer[] c = new Customer[customer];
			for(int i=0; i<customer; i++) {
				c[i] = new Customer();
				c[i].setX(arr[i+2][0]);
				c[i].setY(arr[i+2][1]);
			}
		
			// 순열을 이용하여 고객 내 이동경로 경우의 수 탐색
			min = Integer.MAX_VALUE;
			CusSum(c, 0);

			System.out.println("#" + t + " " + min);
		}
	}
	
	static void CusSum(Customer[] cus, int k) {
		
		if(k == cus.length) {
			
			int csum = Math.abs(arr[0][0] - cus[0].getX()) + Math.abs(arr[0][1] - cus[0].getY());
			for(int i=0; i<cus.length-1; i++)
				csum += Math.abs(cus[i].getX() - cus[i+1].getX()) + Math.abs(cus[i].getY() - cus[i+1].getY());
			csum += Math.abs(arr[1][0] - cus[cus.length-1].getX()) + Math.abs(arr[1][1] - cus[cus.length-1].getY());
			
			if(min > csum)
				min = csum;

			return;
		}
		else {
			for(int i=k; i<cus.length; i++) {
				swap(cus, k, i);
				CusSum(cus, k+1);
				swap(cus, k, i);
			}
		}
	}
	
	static void swap(Customer[] cus, int x, int y) {
		
		Customer temp = cus[y];
		cus[y] = cus[x];
		cus[x] = temp;
	}
}