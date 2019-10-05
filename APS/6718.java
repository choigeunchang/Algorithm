import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			double n = Double.parseDouble(bf.readLine());
			n /= 1000;
			
			int result = 0;
			if (n >= 0.1 && n < 1)
				result = 1;
			else if (n >= 1 && n < 10) {
				result = 2;
			} else if (n >= 10 && n < 100) {
				result = 3;
			} else if (n >= 100 && n < 1000) {
				result = 4;
			} else if(n >= 1000){
				result = 5;
			}
			
			bw.write("#" + t + " " + result + "\n");
			bw.flush();
		}
		bw.close();
	}
}