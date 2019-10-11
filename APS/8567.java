import java.io.*;
import java.util.*;

public class Solution {

	static int[] arr = new int[100001];
	static int[] max_idx = new int[100001];
	
    public static void main(String[] args) throws Exception {
    	
    	calc(arr);
    	max_idx[1] = 1;
    	
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = Integer.parseInt(bf.readLine());

        for(int t=1; t<=test_case; t++) {
        	
        	int n = Integer.parseInt(bf.readLine());
        	bw.write("#" + t +" " + max_idx[n] + "\n");
        	bw.flush();
        }
        bw.close();
    }
    
    static void calc(int[] arr) {
    	
    	int temp = 1;
    	for(int i=2; i<arr.length; i++) {
    		
    		for(int j=i; j<arr.length; j+=i) {
    			
    			arr[j]++;
    			if(arr[i] > arr[temp])
    				temp = i;
    			else if(arr[i] == arr[temp]) {
    				
    				if(i > temp)
    					temp = i;
    			}
    		}
    		
    		max_idx[i] = temp;
    	}
    }
}