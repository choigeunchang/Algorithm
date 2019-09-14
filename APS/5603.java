import java.io.*;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int test_case = Integer.parseInt(br.readLine());
    	
    	for(int t=1; t<=test_case; t++) {
    		
    		int num = Integer.parseInt(br.readLine());
    		int[] arr = new int[num];
    		int sum = 0;
    		for(int i=0; i<num; i++) {
    			arr[i] = Integer.parseInt(br.readLine());
    			sum += arr[i];
    		}
    		
    		int avg = sum/num;
    		int count = 0;
    		for(int i=0; i<num; i++) {
    			
    			if(arr[i] > avg)
    				count += arr[i]-avg;
    		}
    		System.out.println("#" + t + " " + count);
    	}
    }
}