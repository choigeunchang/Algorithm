import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
	
	static ArrayList<Integer> prime;
	static int count;
	static int num;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		prime = new ArrayList<>();
		Erathos(999);
		
		for(int t=1; t<=test_case; t++) {
			
			num = Integer.parseInt(bf.readLine());
			int temp = 0;
			for(int i=0; i<prime.size(); i++) {
				
				if(prime.get(i) > num)
					break;
				temp++;
			}
			
			count = 0;
			reCom(0, temp, 3, 0, 0);
			System.out.println("#" + t + " " + count);
		}
	}
	
	private static void reCom(int sum, int n, int r, int idx, int k) {
		
		if(r == 0) {
			
			if(sum == num)
				count++;
			
			return;
		}
		
		if(sum > num)
			return;
		
		if(k == n)
			return;
		
		reCom(sum+prime.get(k), n, r-1, idx+1, k);
		reCom(sum, n, r, idx, k+1);
	}

	static void Erathos(int n) {
		
		boolean[] flag = new boolean[n+1];
		for(int i=2; i<=n; i++)
			flag[i] = true;
		
		for(int i=2; i*i<=n; i++) {
			
			for(int j=i*i; j<=n; j+=i)
				flag[j] = false;
		}
		
		for(int i=0; i<=n; i++) {
			
			if(flag[i])
				prime.add(i);
		}
	}
}