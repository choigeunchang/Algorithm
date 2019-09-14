import java.util.*;

public class Solution {

    public static void main(String[] args) {

    	Scanner s = new Scanner(System.in);
    	int test_case = s.nextInt();
    	
    	for(int t=1; t<=test_case; t++) {
    		
    		int size = s.nextInt();
    		String[] str = new String[size];
    		for(int i=0; i<size; i++) {
    			str[i] = s.next();
    		}
    		
    		int[][] arr = new int[size][size];
    		
    		for(int i=0; i<size; i++) {
    			for(int j=0; j<size; j++) {
    				arr[i][j] = str[i].charAt(j) - '0';
    			}
    		}
    		
    		int idx = 0, sum = 0;
    		for(int i=0; i<=size/2; i++) {
    			for(int j=size/2-idx; j<=size/2+idx; j++) {
    				sum += arr[i][j];
    			}
    			idx++;
    		}
    		
    		idx--;
    		for(int i=size/2; i<size; i++) {
    			for(int j=size/2-idx; j<=size/2+idx; j++) {
    				sum += arr[i][j];
    			}
    			idx--;
    		}
    		for(int i=0; i<size; i++)
    			sum -= arr[size/2][i];
    		System.out.println("#" + t + " " + sum);
    	}
    }
}