import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int test_case = s.nextInt();

		for(int t=1; t<=test_case; t++) {
			
			int num = s.nextInt();
			int count = 0;
			for(int k=0; k<=num; k++) {
				
				int radix = -k*k - k + 2*num;
				int ordinal = 2*k + 2;
				
				if(radix <= 0 )
					break;
				
				if(radix % ordinal == 0)
					count++;
			}
			System.out.println("#" + t + " " + count);
		}
	}
}