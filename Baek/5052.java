import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			int n= Integer.parseInt(bf.readLine());	            
			String[] numbers = new String[n];
			for (int i = 0; i < n; i++)
				numbers[i] = bf.readLine();
	 
			Arrays.sort(numbers);
			    
			boolean flag = true;
			for (int i = 1; i < n && flag; i++)
			    flag = !numbers[i].startsWith(numbers[i - 1]);
			
			if(flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}