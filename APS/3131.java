
public class Solution {

	static boolean[] check;
	public static void main(String[] args) {
		
		int n = 1000000;
		check = new boolean[n+1];
		StringBuilder sb = new StringBuilder();
		
		prime();
		
		for(int i=1; i<n; i++) {
			if(!check[i])
				sb.append(i + " ");
		}
		
		System.out.println(sb.toString());
	}
	
	static void prime() {
		check[1] = true;
		
		for(int i=2; i<check.length; i++) {
			
			for(int j=2; i*j<check.length; j++)
				check[i*j] = true;
		}
	}
}
