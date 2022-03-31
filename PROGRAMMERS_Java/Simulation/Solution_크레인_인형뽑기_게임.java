package simulation;

import java.util.Stack;

//simulation
public class Solution_크레인_인형뽑기_게임 {
	
	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<Integer>();
        for(int move : moves) {
        	int curr = find(board, move-1);
        	if(curr != 0) {
        		if(!st.isEmpty() && st.peek() == curr) {
        			st.pop();
        			answer++;
        		}else {
        			st.add(curr);
        		}
        	}
        }
        return answer*2;
    }

	private int find(int[][] board, int move) {
		for(int j = 0; j < board[0].length; j++) {
			if(board[j][move] !=0 ) {
				int ret = board[j][move];
				board[j][move] = 0;
				return ret;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Solution_크레인_인형뽑기_게임 solution = new Solution_크레인_인형뽑기_게임();
		System.out.println(solution.solution(new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[] {1,5,3,5,1,2,1,4}));
	}
}