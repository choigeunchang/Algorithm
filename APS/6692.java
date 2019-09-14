import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int test_case = s.nextInt();

		for(int t=1; t<=test_case; t++) {
			
			int num = s.nextInt();
			double[] p = new double[num];
			double[] cash = new double[num];
			double avg = 0;
			for(int i=0; i<num; i++) {
				p[i] = s.nextDouble();
				cash[i] = s.nextDouble();
				avg += p[i] * cash[i];
			}
			
			System.out.printf("#%d %.6f", t, avg);
		}
	}
}