import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static String zero = "CEFGHIJKLMNSTUVWXYZ";
	static String one = "ADOPQR";
	static char two = 'B';
	static String left;
	static String right;
	static String[] lrr;
	static String[] rrr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			left = st.nextToken();
			right = st.nextToken();
			
			String result = "SAME";
			if(left.length() != right.length())
				result = "DIFF";
			else {
				
				lrr = new String[left.length()];
				rrr = new String[right.length()];
				isCheck();
				for(int i=0; i<left.length(); i++) {
					
					if(!lrr[i].equals(rrr[i])) {
						result = "DIFF";
						break;
					}
				}
			}
			
			result = "#" + t + " " + result;
			bw.write(result + "\n");
			bw.flush();
		}
		bw.close();
	}

	static void isCheck() {
		
		for(int i=0; i<left.length(); i++) {
			
			for(int j=0; j<zero.length(); j++) {
				
				if(left.charAt(i) == zero.charAt(j))
					lrr[i] = "0";
				if(right.charAt(i) == zero.charAt(j))
					rrr[i] = "0"; 
			}
			
			for(int j=0; j<one.length(); j++) {
				
				if(left.charAt(i) == one.charAt(j))
					lrr[i] = "1";
				if(right.charAt(i) == one.charAt(j))
					rrr[i] = "1";
			}
			
			if(left.charAt(i) == two)
				lrr[i] = "2";
			if(right.charAt(i) == two)
				rrr[i] = "2";
		}
	}

}
