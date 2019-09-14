import java.io.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
				
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
		
			int n = Integer.parseInt(bf.readLine());
			String[] arr = new String[n];
			for(int i=0; i<n; i++)
				arr[i] = bf.readLine();
			
			boolean flag = true;
			for(int i=0; i<n; i++) {
				
				String[] str = arr[i].split(" ");
				if(str.length == 4) {
					
					if(Character.isDigit(str[1].charAt(0))) {
						flag = false;
						break;
					}
				}
				else if(str.length == 3) {
					
					if(Character.isDigit(str[1].charAt(0))) {
						flag = false;
						break;
					}
				}
				else if(str.length == 2) {
					
					if(!Character.isDigit(str[1].charAt(0))) {
						flag = false;
						break;
					}
				}
			}
			
			if(flag)
				System.out.println("#" + t + " " + 1);
			else
				System.out.println("#" + t + " " + 0);
		}
	}
}