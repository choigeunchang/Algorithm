import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(bf.readLine());
		for(int t=1; t<=test_case; t++) {
			
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			float a = Integer.parseInt(st.nextToken());
			float b = Integer.parseInt(st.nextToken());
			float c = Integer.parseInt(st.nextToken());
			float d = Integer.parseInt(st.nextToken());
			
			float alice = a / b;
			float bob = c/ d;
			
			String result = "#" + t + " DRAW";
			if(alice > bob)
				result = "#" + t + " ALICE";
			else if(alice < bob)
				result = "#" + t + " BOB";
			
			bw.write(result + "\n");
			bw.flush();
		}
		bw.close();
	}
}