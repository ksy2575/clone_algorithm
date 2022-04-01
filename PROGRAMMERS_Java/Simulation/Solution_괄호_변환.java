package simulation;

import java.util.Stack;

// simulation, stack
public class Solution_괄호_변환 {
	public String solution(String p) {
        String answer = "";
        answer = getCorrectBracket(p);
        
        return answer;
    }
	private String getCorrectBracket(String p) {
        if(p.equals("")) return "";
		String[] brackets = getBalancedBrackets(p);
		
		if(brackets != null && isGoodBrackets(brackets[0])) {
			return brackets[0] + getCorrectBracket(brackets[1]);
		}else {
			String temp = "(" + getCorrectBracket(brackets[1]) + ")"; // (((()) -> ))))((
			String temp2 = brackets[0].substring(1, brackets[0].length()-1).replace('(', '0').replace(')', '(').replace('0', ')');
			return temp+temp2;
		}
		
	}
	private boolean isGoodBrackets(String string) {
		Stack<Character> st = new Stack<Character>();
		for(char c : string.toCharArray()) {
			if(!st.isEmpty() && st.peek() == '(' && c == ')') st.pop();
			else st.add(c);
		}
		return st.isEmpty()?true:false;
	}
	private String[] getBalancedBrackets(String p) {
		int l = 0;
		int r = 0;
		for(int i = 0; i < p.length(); i++) {
			if(p.charAt(i)=='(') l++;
			if(p.charAt(i)==')') r++;
			if(l==r) return new String[] {p.substring(0, i+1), p.substring(i+1)};
			
		}
		return null;
	}
	public static void main(String[] args) {
		Solution_괄호_변환 solution = new Solution_괄호_변환();
//		System.out.println(solution.solution("(()())()")); // "(()())()"
//		System.out.println(solution.solution(")(")); // "(()())()"
		System.out.println(solution.solution("()))((()")); // "(()())()"
	}
}
