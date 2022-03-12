package dp;

import java.util.Arrays;

public class Solution_정수_삼각형 {
	
	public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];
        dp[0] = new int[1];
    	dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++) {
        	int[] line = triangle[i];
        	dp[i] = new int[line.length];
        	
        	for(int j = 0; j < dp[i].length;j++) {
        		if(j == 0) {
        			dp[i][j] = dp[i-1][j] + triangle[i][j];
        		}else if(j == dp[i].length-1) {
        			dp[i][j] = dp[i-1][j-1] + triangle[i][j];
        		}else {
        			dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
        		}
        	}
        }
        return Arrays.stream(dp[triangle.length-1]).max().getAsInt();
    }
	
	public static void main(String[] args) {
		Solution_정수_삼각형 solution = new Solution_정수_삼각형();
		System.out.println(solution.solution(new int[][] {{7},{3, 8},{8, 1, 0},{2, 7, 4, 4},{4, 5, 2, 6, 5}}));
	}
}
