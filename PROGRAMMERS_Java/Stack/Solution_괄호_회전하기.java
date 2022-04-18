package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Stack
public class Solution_괄호_회전하기 {
	public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
        	Queue<Character> q = getQueue(s, i);
        	if(isCorrect(q)) answer++;
        }
        return answer;
    }
	private boolean isCorrect(Queue<Character> q) {
		Stack<Character> st = new Stack<Character>();
		while(!q.isEmpty()) {
			char c = q.poll();
			if(st.isEmpty()) {
				st.add(c);
				continue;
			}
			if((st.peek() == '[' && c == ']') || (st.peek() == '{' && c == '}') || (st.peek() == '(' && c == ')')) {
				st.pop();
			}else {
				st.add(c);
			}
		}
		return st.isEmpty()?true:false;
	}
	private Queue<Character> getQueue(String s, int i) {
		Queue<Character> retQueue = new LinkedList<Character>();
		int cnt = 0;
		
		while(cnt++ < s.length()) {
			retQueue.add(s.charAt(i++));
			if(i >= s.length()) i = 0;
		}
		return retQueue;
	}
	public static void main(String[] args) {
		Solution_괄호_회전하기 solution = new Solution_괄호_회전하기();
		System.out.println(solution.solution("[](){}"));
	}

}
