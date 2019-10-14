import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			int size = Integer.parseInt(bf.readLine());
			String str = bf.readLine();
			int[][] arr = new int[size][8];
			char[] res = new char[size];
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<size; i++) {
				for(int j=0; j<8; j++) {
					if(str.charAt(j+8*i) == 'I') {
						arr[i][j] = 1;
						res[i] += (1<<8-j-1);
					}
					else if(str.charAt(j+8*i) == 'O')
						arr[i][j] = 0;
				}
				sb.append(res[i]);
			}
			
			bw.write("Case #" + t + ": " + sb.toString() + "\n");
			bw.flush();
		}
		bw.close();
	}
	
	static void print(int[][] arr) {
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
}