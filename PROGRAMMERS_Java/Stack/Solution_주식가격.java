package stack;

import java.util.Arrays;
import java.util.Stack;

public class Solution_주식가격 {
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return x + " : " + y;
		}
		
	}
	public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Point> list = new Stack<Point>();
        for (int i = 0; i < prices.length; i++) {
        	int curr = prices[i];
        	while(!list.isEmpty() && list.peek().x > curr) {
        		Point last = list.pop();
        		answer[last.y] = i-last.y;
        	}
			list.add(new Point(prices[i], i));
		}
        while(!list.isEmpty()) {
    		Point last = list.pop();
    		answer[last.y] = prices.length-last.y-1;
    	}
        return answer;
    }
	
	public static void main(String[] args) {
		Solution_주식가격 solution = new Solution_주식가격();
		System.out.println(Arrays.toString(solution.solution(new int[] {1, 2, 3, 2, 3})));
	}
}
