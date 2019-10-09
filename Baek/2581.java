import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int m = Integer.parseInt(bf.readLine());
		int n = Integer.parseInt(bf.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		boolean[] flag = new boolean[n+1];
		flag[0] = true;
		flag[1] = true;
		int sum = 0;
		int min = 0;
		// 에라토스테네스
		for(int i=2; i*i<=n; i++) {
			for(int j=i*i; j<=n; j+=i)
				flag[j] = true;
		}
		for(int i=0; i<=n; i++) {
			if(!flag[i] && i>=m && i<=n) {
				list.add(i);
				sum += i;
			}
		}
		if(list.size() == 0)
			bw.write(-1 + "\n");
		else {
			min = list.get(0);	
			bw.write(sum + "\n" + min + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
