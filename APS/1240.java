import java.io.*;
import java.util.*;

public class Solution {

	static String[] str = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			String nm = bf.readLine();
			StringTokenizer st = new StringTokenizer(nm);
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			String[] arr = new String[n];
			int x = 0, y = 0;
			boolean flag = false;
			for(int i=0; i<n; i++) {
				
				arr[i] = bf.readLine();
				if(!flag) {
					for(int j=m-1; j>=0; j--) {
						if(arr[i].charAt(j)-'0' == 1) {
							x = i;
							y = j;
							flag = true;
							break;
						}
					}
				}
			}
			
			int[] temp = new int[8];
			int idx = 0;
			for(int i=y; i>=y-56+1; i-=7) {
				
				String a = arr[x].substring(i-6, i+1);
				for(int j=0; j<10; j++) {
					if(str[j].equals(a)) {
						temp[8-idx-1] = j;
						idx++;
					}
				}
			}
			
			int result = 0;
			for(int i=0; i<8; i++)
				result += temp[i];
			
			int sum = (temp[0] + temp[2] + temp[4] + temp[6]) * 3 + temp[1] + temp[3] + temp[5] + temp[7];
			if(sum % 10 == 0)
				System.out.println("#" + t + " " + result);
			else
				System.out.println("#" + t + " " + 0);
		}
	}	
}