import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
   
   static int[] arr;
   static int[] brr;
   static int resulta;
   static int resultb;
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      int test_case = Integer.parseInt(bf.readLine());
      
      for(int t=1; t<=test_case; t++) {
         
         String str = bf.readLine();
         StringTokenizer st = new StringTokenizer(str);
         arr = new int[9];
         brr = new int[9];
         boolean[] flag = new boolean[19];
         for(int i=0; i<9; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            flag[arr[i]] = true; 
         }
         
         int idx = 0;
         for(int i=1; i<=18; i++) {
        	 
        	 if(!flag[i]) {
        		 brr[idx] = i;
        		 idx++;
        	 }
         }
         resulta = 0;
         resultb = 0;
         perm(0);
         System.out.println("#" + t + " " + resulta + " " + resultb);
      }
   }
   
   static void perm(int k) {
      
      if(k == brr.length) {
         
         int counta = 0;
         int countb = 0;
         for(int i=0; i<9; i++) {
            
            int temp = arr[i] + brr[i];
            if(arr[i] > brr[i])
               counta += temp;
            else if(arr[i] < brr[i])
               countb += temp;
         }
         if(counta > countb)
            resulta++;
         else if(counta < countb)
            resultb++;
      }
      else {
         for(int i=k; i<brr.length; i++) {
            
            swap(k, i);
            perm(k+1);
            swap(k, i);
         }
      }
   }

   static void swap(int x, int y) {
      
      int temp = brr[x];
      brr[x] = brr[y];
      brr[y] = temp;
   }
}