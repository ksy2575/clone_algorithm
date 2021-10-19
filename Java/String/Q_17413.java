package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q_17413 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		try {
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		StringBuffer ans = new StringBuffer();
		Boolean isTag = false;
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0;i<s.length();i++) {
			
			char curr = s.charAt(i);
			
			if(curr=='<') {
				isTag = true;
				popStack(ans, stack);
				stack.clear();
				ans.append('<');
				
			}else if(curr=='>') {
				isTag = false;
				ans.append('>');
				
				
			}else if(!isTag && curr==' '){
				popStack(ans, stack);
				ans.append(' ');
				stack.clear();
			}else{
				if(isTag) {
					ans.append(curr);
				}else {
					stack.add(curr);
				}
			}
			
		}
		popStack(ans, stack);
		System.out.println(ans);
		
	}

	public static void popStack(StringBuffer ans, Stack<Character> stack) {
		while(stack.size()>0) {
			ans.append(stack.pop());
		}
	}
}
