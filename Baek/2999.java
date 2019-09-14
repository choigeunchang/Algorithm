import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		
		int n = str.length();
		int r = 0;
		int c = 0;
		int max = 0;
		for(int i=1; i<=n; i++) {
			
			c = i;
			r = n / c;
			if(r <= c && r * c == n) {
				if(max < r)
					max = r;
			}
		}
		
		char[][] res = new char[max][n/max];
		for(int i=0; i<max; i++) {
			
			for(int j=0; j<n/max; j++)
				res[i][j] = str.charAt(max*j+i); 
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<max; i++) {
			
			for(int j=0; j<n/max; j++)
				sb.append(res[i][j]);
		}
		System.out.println(sb.toString());
	}
}