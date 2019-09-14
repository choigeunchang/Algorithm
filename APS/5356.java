import java.io.*;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			String[] str = new String[5];
			int max = 0;
			for(int i=0; i<5; i++) {
				str[i] = bf.readLine();
				if(max < str[i].length())
					max = str[i].length();
			}
			
			char[][] arr = new char[5][max];
			for(int i=0; i<5; i++) {
				
				for(int j=0; j<max; j++) {
					
					if(j>=str[i].length())
						arr[i][j] = ' ';
					else
						arr[i][j] = str[i].charAt(j);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<max; i++) {
				
				for(int j=0; j<5; j++) {
					
					if(arr[j][i] == ' ')
						sb.append("");
					else
						sb.append(arr[j][i]);
				}
			}
			
			System.out.println("#" + t + " " + sb.toString());
		}
	}
}