import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int test_case = s.nextInt();
		
		for(int t=0; t<test_case; t++) {
			
			String str = s.next();
			int stick = 0;
			int result = 0;
			for(int i=0; i<str.length(); i++) {
				
				char c = str.charAt(i);
				
				if(c == '(') {
					// 내가 열림
					char next_char = str.charAt(i+1);
					if(next_char == '(') {
						// i위치에서 막대기 시작
						stick++;
					}
				}
				else if(c == ')') {
					// 내가 닫힘
					char pre_char = str.charAt(i-1);
					if(pre_char == '(') {
						// i위치에서 레이저 떨어짐
						result += stick;
					}
					else if(pre_char == ')') {
						// i위치에서 막대기 끝남
						stick--;
						result++;
					}
				}
			}
			System.out.println("#" + (t+1) + " " + result);
		}
	}
}