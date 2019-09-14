import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
 
    static int count = 0;
    public static void main(String[] args) throws NumberFormatException, IOException {
       
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(bf.readLine());
       
        for(int t=1; t<=test_case; t++) {
          
            int n = Integer.parseInt(bf.readLine());
            int[] arr = new int[n];
          
            count = 0;
            Queen(arr, n, 0);
            System.out.println("#" + t + " " + count);
        }
    }
     
    static void Queen(int[] arr, int n, int row) {
         
        if(row == n) {
            count++;
            return;
        }
         
        for(int i=0; i<n; i++) {
             
            arr[row] = i;
            if(check(arr, row))
                Queen(arr, n, row+1);
        }
    }
 
    static public boolean check(int[] arr, int row) {
         
        for(int i=0; i<row; i++) {
             
            if(Math.abs(arr[i] - arr[row]) == Math.abs(i - row) || arr[i] == arr[row])
                return false;
        }
        return true;
    }
}