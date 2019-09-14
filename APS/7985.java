import java.util.*;

public class Solution {
	
	private static int[] arr;
	private static int[] res;
	static int k;
	private int cur = 0;
	private int size = 1;
	public Solution(int n) {
		
		arr = new int[(1<<n)];
		res = new int[(1<<n)];
	}

	public void inorder(int node) {
		
		if(cur == k) {
			cur--;
			return;
		}
		
		cur++;
		inorder(2*node);
		res[node] = arr[size];
		size++;
		cur++;
		inorder(2*node+1);
		cur--;
	}

	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<k; i++) {
			
			for(int j=0; j<(1<<i); j++) {
				
				sb.append(res[(1<<i) + j]).append(" ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int test_case = s.nextInt();
		
		for(int t=1; t<=test_case; t++) {
			
			k = s.nextInt();
			Solution st = new Solution(k);
			for(int i=1; i<arr.length; i++) {
				arr[i] = s.nextInt();
			}

			st.inorder(1);
			System.out.print("#" + t + " ");
			System.out.print(st.toString());
		}
	}	
}