import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int test_case = 0;
		int num = 0, submit = 0;
		
		test_case = s.nextInt();
		
		for(int k=0; k<test_case; k++) {
			
			num = s.nextInt();		// 수강생의 수
			submit = s.nextInt();	// 제출 학생 수
			int[] arr_test = new int[num];
			int[] arr = new int[submit];
			
			for(int i=0; i<num; i++)	// 전체 선언
				arr_test[i] = i+1;
			
			for(int i=0; i<submit; i++)	// 제출한 사람의 번호 입력
				arr[i] = s.nextInt();
			
			// 판별
			for(int i=0; i<num; i++) {
				
				for(int j=0; j<submit; j++) {
					
					if(arr_test[i] == arr[j])
						arr_test[i] = 0;
				}
			}
			
			System.out.print("#" + (k+1) + " ");
			for(int i=0; i<arr_test.length; i++) {
				
				if(arr_test[i] != 0)
					System.out.print(arr_test[i] + " ");
			}
			System.out.println();
		}	
	}
}