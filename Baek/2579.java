import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(bf.readLine());
		
		int[] stairs = new int[n];
		
		// 어차피 최대값을 구하는 것이기 때문에 오를 때마다 최대값을 구하면서 올라가면 된다.
		stairs[0] = arr[0];
		stairs[1] = Math.max(arr[1], arr[0] + arr[1]);
		stairs[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
		
		for(int i=3; i<n; i++) {
			
			int a = arr[i-1] + arr[i] + stairs[i-3];
			int b = arr[i] + stairs[i-2];
			stairs[i] = Math.max(a, b);
		}
		
		bw.write(stairs[n-1]+"\n");
		bw.flush();
		bw.close();
	}
}
