import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String result = "";
		
		for(int i=0; i<3; i++) {
			
			int[] arr = new int[4];
			int count = 0;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0; j<4; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				if(arr[j] == 0)
					count++;
			}
			
			if(count == 0)
				result = "E";
			else if(count == 1)
				result = "A";
			else if(count == 2)
				result = "B";
			else if(count == 3)
				result = "C";
			else if(count == 4)
				result = "D";

			bw.write(result + "\n");
			bw.flush();
		}
		bw.close();
	}
}