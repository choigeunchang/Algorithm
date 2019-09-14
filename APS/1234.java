import java.util.*;

public class Solution {
   
    public static void main(String[] args) {

    	Scanner s = new Scanner(System.in);
        for(int t=1; t<=10; t++) {
         
        	int n = s.nextInt();
        	StringBuilder str = new StringBuilder(s.next());
        	
        	for(int i=0; i<str.length()-1; i++) {
        		
        		if(str.charAt(i) == str.charAt(i+1)) {
        			str.delete(i, i+2);
        			i = -1;
        		}
        	}
        	System.out.println("#" + t + " " + str.toString());
        }	
    }
}