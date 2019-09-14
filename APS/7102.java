import java.util.*;
   
public class Solution {

    public static void main(String[] args) {
         
       Scanner s = new Scanner(System.in);
       int test_case = s.nextInt();
       
       for(int t=1; t<=test_case; t++) {
    	   
    	   int N = s.nextInt();
    	   int M = s.nextInt();
    	   
    	   System.out.print("#" + t + " ");
    	   if(N > M) {
    		   for(int i=1+M; i<=1+N; i++)
    			   System.out.print(i + " ");
    	   }
    	   else {
    		   for(int i=1+N; i<=1+M; i++)
    			   System.out.print(i + " ");
    	   }
    	   System.out.println();
       }
    }
}