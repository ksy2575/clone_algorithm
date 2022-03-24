package lv2;

import java.util.Stack;

//stack 좋은 문제
public class Solution_짝지어_제거하기 {
	public int solution(String s)
    {
        Stack<Character> stack = new Stack<Character>();
        for(Character c : s.toCharArray()) {
        	if(!stack.isEmpty() && stack.peek() == c) stack.pop();
        	else stack.add(c);
        }
        return stack.isEmpty()?1:0;
    }
	
	public static void main(String[] args) {
		Solution_짝지어_제거하기 solution = new Solution_짝지어_제거하기();
		System.out.println(solution.solution("baabaa"));
	}
}
