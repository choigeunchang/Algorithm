import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Weight implements Comparable<Weight>{
	
	int x, y, wei;

	public Weight() {}
	public Weight(int x, int y, int wei) {
		this.x = x;
		this.y = y;
		this.wei = wei;
	}
	@Override
	public int compareTo(Weight o) {
		if(o.wei < this.wei)
			return 1;
		else if(o.wei == this.wei)
			return 0;
		else
			return -1;
	}
}

public class Solution {

	static int[] arr;
	static ArrayList<Weight> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		for(int t=1; t<=test_case; t++) {
			
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			arr = new int[v+1];
			for(int i=0; i<arr.length; i++)
				arr[i] = i;
			
			list = new ArrayList<>();
			for(int i=0; i<e; i++) {
				str = bf.readLine();
				st = new StringTokenizer(str);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list.add(new Weight(a, b, c));
			}
			
			Collections.sort(list);

			long total = 0;
			for(int i=0; i<list.size(); i++) {
				
				Weight temp = list.get(i);
				temp.x = findset(temp.x);
				temp.y = findset(temp.y);
				if(temp.x != temp.y) {
					total += temp.wei;
					union(temp.x, temp.y);
				}
			}
			System.out.println("#" + t + " " + total);
		}
	}
	
	static int findset(int x) {
		
		if(x == arr[x])
			return x;
		
		arr[x] = findset(arr[x]);
		return arr[x];
	}
	
	static void union(int x, int y) {
		
		x = findset(x);
		y = findset(y);
		if(x != y)
			arr[y] = x;
	}
}
