import java.io.*;
import java.util.*;

public class Solution {
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = Integer.parseInt(bf.readLine());
        
        for(int t=1; t<=test_case; t++) {
        	
            int n = Integer.parseInt(bf.readLine());
            TreeSet<String> list = new TreeSet<String>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int o1s = o1.length();
                    int o2s = o2.length();
                    if(o1s > o2s) {
                        return 1;
                    }
                    else if(o1s == o2s) {
                        return o1.compareTo(o2);
                    }
                    return -1;
                }
            });
            
            for(int i=0; i<n; i++)
                list.add(bf.readLine().trim());
            
            bw.write("#" + t + "\n");
            for(String str : list)
            	bw.write(str + "\n");
            bw.flush();
        }
        bw.close();
    }
}