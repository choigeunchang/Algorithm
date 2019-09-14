import java.util.Scanner;
  
public class Solution {
	
    public static void main(String[] args) {
          
        Scanner s = new Scanner(System.in);
        int test_case = 0;
        
        test_case = s.nextInt();	// 테스트 갯수
        int[] count = new int[test_case];
        
        // 각 테스트 케이스 입력
        for(int t=0; t<test_case; t++) {
        	
        	char[] arr = s.next().toCharArray();
        	char[] temp = new char[arr.length];
        	count[t] = 0;
        	
        	// initialation
        	for(int i=0; i<arr.length; i++)
        		temp[i] = '0';
        	
        	for(int i=0; i<arr.length; i++) {
        		
        		if(arr[i] != temp[i]) {
        			
        			for(int j=i; j<arr.length; j++) {
        				
        				if(arr[i] == '1')
        					temp[j] = '1';
        				else
        					temp[j] = '0';
        			}
        			count[t]++;
        		}
        	}
        }
        
        for(int i=0; i<test_case; i++)
        	System.out.println("#" + (i+1) + " " + count[i]);
    }
}
