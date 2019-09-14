import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int test_case = s.nextInt();

		for(int t=1; t<=test_case; t++) {
			
			int n = s.nextInt();
			int k = s.nextInt();
			int sum = 0, avg = 0;
			for(int i=1; i<=n*k; i++)
				sum += i;

			avg = Math.round((float)sum/k);
			
			System.out.print("#" + t + " ");
			if(n % 2 == 1) {
				
				for(int i=0; i<k; i++)
					System.out.print(avg - k/2 + i + " ");
			}
			else if(n % 2 == 0){
				for(int i=0; i<k; i++)
					System.out.print(avg + " ");
			}
			System.out.println();
		}
	}
}