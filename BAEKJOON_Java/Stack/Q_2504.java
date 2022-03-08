package baekjoon.Simulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Q_2504 {
	static Map<Character, Integer> map = new HashMap<Character, Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		Stack<Integer> st = new Stack<Integer>();
		
		map.put('[', -4);
		map.put(']', -3);
		map.put('(', -2);
		map.put(')', -1);
		
		for(char c : s.toCharArray()) {
			int curr = map.get(c);
			
			if(curr%2 == 0) {
				st.add(curr);
			}
			
			else if(curr == -1 || curr == -3) {
				int temp = 0;
				while(true) {
					if(st.isEmpty() || (st.peek() != curr-1 && st.peek() < 0)) {
						System.out.println(0);
						return;
					}
					if(st.peek() == curr-1) break;
					
					temp += st.pop();
				}
				if(temp == 0) temp = 1;
				st.pop();
				st.add(temp * (curr==-1?2:3));
			}
		}
		int ans = 0;
		while(!st.isEmpty()) {
			int curr = st.pop();
			if(curr < 0) {
				System.out.println(0);
				return;
			}
			ans += curr;
		}
		System.out.println(ans);
	}

}
