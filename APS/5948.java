import java.io.*;
import java.util.*;

public class Solution {

	static ArrayList<Integer> res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
		
			String str = bf.readLine();
			ArrayList<Integer> input = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(str);
			while(st.hasMoreTokens()) {
				input.add(Integer.parseInt(st.nextToken()));
			}

			int[] arr = new int[input.size()];
			for(int i=0; i<arr.length; i++)
				arr[i] = input.get(i);
		
			res = new ArrayList<>();
			int[] sel = new int[3];
			combination(arr, 0, 0, sel);
		
			custom_sort(res);
			int cnt = 1;
			int max = res.get(0);
		
			for(int i=0; i<res.size(); i++) {
				
				if(res.get(i) < max) {
					max = res.get(i);
					cnt++;
				}
				if(cnt == 5) {
					System.out.println("#" + t + " " + max);
					break;
				}
			}
		}
	}

	static void combination(int[] arr, int n, int r, int[] sel) {
		
		if(r == sel.length) {
			res.add(sum(sel));
			return;
		}
		
		if(n == arr.length)
			return;
		
		sel[r] = arr[n];
		combination(arr, n+1, r+1, sel);
		combination(arr, n+1, r, sel);
	}
	
	static int sum(int[] arr) {
		
		int sum = 0;
		for(int i=0; i<arr.length; i++)
			sum += arr[i];
		
		return sum;
	}
	
	static void custom_sort(ArrayList<Integer> arr) {
		
		for(int i=0; i<arr.size()-1; i++) {
			
			for(int j=i; j<arr.size(); j++) {
				
				if(arr.get(i) < arr.get(j)) {
					int temp = arr.get(j);
					arr.set(j, arr.get(i));
					arr.set(i, temp);
				}
			}
		}
	}
}