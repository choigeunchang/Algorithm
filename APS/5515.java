import java.util.*;
  
public class Solution {
 
    static int[] calender = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
     
    public static void main(String[] args) {
         
        Scanner s = new Scanner(System.in);
        int test_case = s.nextInt();
          
        for(int t=1; t<=test_case; t++) {
         
            int m = s.nextInt();
            int d = s.nextInt();
             
            int temp = 0;
            for(int i=0; i<m-1; i++)
                temp += calender[i];
            temp += d;
 
            System.out.println("#" + t + " " + ((temp+3)%7));
        }   
    }   
}