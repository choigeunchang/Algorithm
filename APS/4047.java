import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
       
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			String str = bf.readLine();
			String[][] arr = new String[str.length()/3][2];
			for(int i=0; i<arr.length; i++) {
				arr[i][0] = str.substring(3*i, 3*i+1);
				arr[i][1] = str.substring(3*i+1, 3*i+3);
			}

			if(check(arr))
				System.out.println("#" + t + " " + getCard(arr));
			else
				System.out.println("#" + t + " ERROR");
		}
	}
    
    static boolean check(String[][] arr) {
	
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				
				if(arr[i][0].equals(arr[j][0]) && arr[i][1].equals(arr[j][1]))
					return false;
			}
		}
		
		return true;
    }
    
    static String getCard(String[][] arr) {
    	
    	int[] cnt = {13, 13, 13, 13};
    	for(int i=0; i<arr.length; i++) {
    		
    		if(arr[i][0].equals("S"))
    			cnt[0]--;
    		else if(arr[i][0].equals("D"))
    			cnt[1]--;
    		else if(arr[i][0].equals("H"))
    			cnt[2]--;
    		else if(arr[i][0].equals("C"))
    			cnt[3]--;
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<cnt.length; i++)
    		sb.append(cnt[i] +" " );
    	
    	return sb.toString();
    }
}