import java.util.*;

public class Main {
	
	static int[] num = {1, 5, 10, 50};
	static int n;
	static int res;
	static boolean[] flag;
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		flag = new boolean[50*n+1];
		res = 0;
		re_perm(0, 0, 0);
		
		System.out.println(res);
	}
	
	static void re_perm(int cur, int sel, int sum) {
		
		if(cur == n) {
			if(!flag[sum]) {
				flag[sum] = true;
				res++;
			}
		}
		else {
			for(int i=sel; i<num.length; i++)
				re_perm(cur+1, i, sum+num[i]);
		}
		
	}
}