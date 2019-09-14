import java.util.*;
 
public class Solution {
     
    public static void main(String[] args) {
         
        int dump = 0;
        int[] arr = new int[100];
        Scanner s = new Scanner(System.in);
         
        for(int t=0; t<10; t++) {
             
            dump = s.nextInt();
            for(int i=0; i<100; i++) {
                 
                arr[i] = s.nextInt();
            }
            System.out.println("#" + (t+1) + " " + flatten(dump, arr));
        }
    }
     
    public static int flatten(int dump, int[] arr) {
         
        int diff = 0;       
        for(int i=0; i<dump; i++) {      // 덤프 반복
             
            Arrays.sort(arr);
            arr[0]++;
            arr[99]--;
            Arrays.sort(arr);       // ++, -- 되면서 최대 최소 인덱스가 바뀔 수도 있으니 다시 정렬해줘야 한다.
            diff = arr[99] - arr[0];
             
            if(diff == 1 || diff == 0)
                break;
        }
        return diff;
    }
}