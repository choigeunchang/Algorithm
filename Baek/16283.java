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
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int goat = 0;
		int sheep = 0;
		int temp = 0;
		int ses = 0;
		int ges = 0;
		for(sheep=1; sheep<n; sheep++) {
			
			goat = n - sheep;
			if(a*sheep + b*goat == w) {
				ses = sheep;
				ges = goat;
				temp++;
			}
		}
		
		if(temp == 1)
			bw.write(ses + " " + ges + "\n");
		else
			bw.write(-1 + "\n");
		
		bw.flush();
		bw.close();
	}
}