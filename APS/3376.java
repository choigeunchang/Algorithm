import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
          
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(bf.readLine());
        
        long[] arr = new long[100];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        for(int i=3; i<100; i++)
        	arr[i] = arr[i-3] + arr[i-2];
        
        for(int t=1; t<=test_case; t++) {
        	
        	int n = Integer.parseInt(bf.readLine());
        	System.out.println("#" + t + " " + arr[n-1]);
        }
    }
}