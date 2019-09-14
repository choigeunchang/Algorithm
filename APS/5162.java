import java.util.*;
 
public class Solution {
	
	static int a, b, c;
	
	public static void main(String[] args) {
		
        Scanner s = new Scanner(System.in);
        int test_case = s.nextInt();
         
        for(int t=1; t<=test_case; t++) {
        	
        	a = s.nextInt();
        	b = s.nextInt();
        	c = s.nextInt();
        	
        	int x = 0, y = 0;
        	if(a < b) {
        		
        		for(int i=0; a*i<=c; i++)
        			x=i;
        		y = (c - a*x) / b;
        	}        		
        	else {
        		for(int i=0; b*i<=c; i++)
        			y=i;
        		x = (c - b*y) / a;
        	}
        	
        	System.out.println("#" + t + " " + (x+y));
        }	
    }	
}