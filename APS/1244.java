import java.io.*;
import java.util.*;
import java.util.StringTokenizer;


public class Solution {
 
	static int n;
	static int[] arr;
	static int max;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
       
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			String money = st.nextToken();
			arr = new int[money.length()];
			for(int i=0; i<arr.length; i++)
				arr[i] = money.charAt(i) - '0';
			n = Integer.parseInt(st.nextToken());
			
			max = 0;
			dfs(0, 0);
			
			System.out.println("#" + t + " " + max);
		}
	}
    
    static void dfs(int current, int k) {
    	
    	if(k == n) {
    		max = Math.max(max, getMoney());
    		return;
    	}
    		
    	for(int i=current; i<arr.length; i++) {
    		
    		for(int j=i+1; j<arr.length; j++) {
    			
    			if(arr[i] <= arr[j]) {
	    			swap(i, j);
	        		dfs(i, k+1);
	        		swap(j, i);
    			}
    		}
    	}
    }
    
    static void swap(int x, int y) {
    	
    	int temp = arr[y];
    	arr[y] = arr[x];
    	arr[x] = temp;
    }
    
    static int getMoney() {
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<arr.length; i++)
    		sb.append(arr[i]);
    	
    	return Integer.parseInt(sb.toString());
    }
}