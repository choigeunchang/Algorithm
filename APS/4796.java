import java.util.*;

public class Solution {
	
	static int num;
	static int[] arr;
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int test_case = s.nextInt();
		for(int t=1; t<=test_case; t++) {

			num = s.nextInt();
			arr = new int[num+1];
			for(int i=1; i<=num; i++)
				arr[i] = s.nextInt();
			
			System.out.println("#" + t + " " + mountain());
		}
	}
	
	static int mountain() {
		
		boolean flag = true;		// 현황 체크
		int up = 0;
		int down = 0;
		int result = 0;
		
		for(int i=1; i<num; i++) {
			
			if(flag && arr[i] < arr[i+1])		// 올라가는중
				up++;
			else if(flag && arr[i] > arr[i+1]) {	// 내려가기 시작
				flag = false;
				down++;
			}
			else if(!flag && arr[i] < arr[i+1]) {	// 올라가기 시작
				flag = true;
				result += up*down;
				up = 1;
				down = 0;
			}
			else if(!flag && arr[i] > arr[i+1])		// 내려가는 중
				down++;
		}
		result += up*down;
		
		return result;
	}
}