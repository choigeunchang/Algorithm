import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		
		for(int t=1; t<=10; t++) {
			
			int num = s.nextInt();
			String str = s.next();
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<num; i++) {
				
				char c = str.charAt(i);
				if(Character.isDigit(c))
					sb.append(c);
				else if(c == '(')
					stack.push(c);
				else if(c == '+') {
					while(!stack.empty() && stack.peek() != '(') {
						sb.append(stack.pop());
					}
					stack.push(c);
				}
				else if(c == '*') {
					while(!stack.empty() && stack.peek() != '+' && stack.peek() != '(') {
						sb.append(stack.pop());
					}
					stack.push(c);
				}
				else if(c == ')') {
					char top;
					while(!stack.empty() && (top = stack.pop()) != '(') {
						sb.append(top);
					}
				}
			}
			while(!stack.empty()) {
				sb.append(stack.pop());
			}

			int result = 0;
			Stack<Integer> stack1 = new Stack<>();
			for(int i=0; i<sb.length(); i++) {
	    	   
				char c = sb.charAt(i);
				if(Character.isDigit(c)) {
					stack1.push(c - '0');
				}
				else if (c == '+' || c == '*'){
					int x = 0, y = 0, res = 0;
					if(c == '+') {
						x = stack1.pop();
						y = stack1.pop();
						res = y + x;
						stack1.push(res);
					}
					else if(c == '*') {
						x = stack1.pop();
						y = stack1.pop();
						res = y * x;
						stack1.push(res);
					}
				}
				else
					stack1.pop();
			}
			result = stack1.pop();
			System.out.println("#" + t + " " + result);
		}
	}
}