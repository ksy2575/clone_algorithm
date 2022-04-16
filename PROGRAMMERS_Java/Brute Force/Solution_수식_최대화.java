package lv2;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution_수식_최대화 {
	
	public long solution(String expression) {
        long answer = 0;
        char[] ex = new char[] {'*', '+', '-'};
    	int[][] orders = new int[][] {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}};
        for(int[] order : orders) {
        	char[] curr = getCurrEx(ex, order);
        	System.out.println(Arrays.toString(curr));
        	LinkedList<Long> nums = getNumList(expression);
        	LinkedList<Character> exs = getExList(expression);
        	answer = Math.max(answer, getMaxAbs(nums, exs, curr));
        }
        return answer;
    }
	private long getMaxAbs(LinkedList<Long> nums, LinkedList<Character> exs, char[] curr) {
		for(char c : curr) {
			for(int i = 0; i < exs.size(); i++) {
				if(exs.get(i) == c) {
					long temp = 0;
					if(c=='*') temp = nums.get(i) * nums.get(i+1);
					else if(c=='+') temp = nums.get(i) + nums.get(i+1);
					else temp = nums.get(i) - nums.get(i+1);
					nums.remove(i);
					nums.remove(i);
					nums.add(i, temp);
					exs.remove(i);
				}
			}
		}
		return 0;
	}
	private LinkedList<Long> getNumList(String expression) {
		LinkedList<Long> retList = new LinkedList<Long>();
		for(String s: expression.split("[*|+|-]")) {
			retList.add(Long.parseLong(s));
		}
		System.out.println(retList);
		return retList;
	}
	private LinkedList<Character> getExList(String expression) {
		LinkedList<Character> retList = new LinkedList<Character>();
		for(char c: expression.toCharArray()) {
			if(!Character.isDigit(c)) retList.add(c);
		}
		System.out.println(retList);
		return retList;
	}
	private char[] getCurrEx(char[] ex, int[] order) {
		char[] ret = new char[3];
		for(int i = 0; i < 3; i++) {
			ret[i] = ex[order[i]];
		}
		return ret;
	}
	public static void main(String[] args) {
		Solution_수식_최대화 solution = new Solution_수식_최대화();
		System.out.println(solution.solution("100-200*300-500+20"));
	}

}
