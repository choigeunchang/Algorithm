import java.util.*;
 
public class Solution {

	public static void main(String[] args) {
		
        Scanner s = new Scanner(System.in);
        int test_case = s.nextInt();
         
        for(int t=1; t<=test_case; t++) {
        
        	String n = s.next();
        	int num = n.charAt(n.length()-1) - '0';
        	
        	if(num % 2 == 0)
        		System.out.println("#" + t + " Even");
        	else if(num % 2 == 1)
        		System.out.println("#" + t + " Odd");
        }	
    }	
}