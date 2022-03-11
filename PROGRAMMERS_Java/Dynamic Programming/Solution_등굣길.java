package dp;

public class Solution_등굣길 {
	static int[][] dp;
	public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        dp = new int[n][m];
        dp[0][0] = 1;
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		if((i == 0 && j == 0) || isPuddle(puddles, i, j)) continue;
        		else if(i == 0) {
            		dp[i][j] = dp[i][j-1]%1000000007;
            	}else if(j == 0) {
            		dp[i][j] = dp[i-1][j]%1000000007;
            	}else {
            		dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1000000007;
            	}
            }
        }
        print(dp);
        return dp[n-1][m-1];
    }
	
	private void print(int[][] dp) {
		for(int i = 0; i < dp.length;i++) {
			for(int j = 0; j < dp.length;j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	public boolean isPuddle(int[][] puddles, int i, int j) {
		for(int[] puddle : puddles) {
			if(puddle[0] == j+1 && puddle[1] == i+1) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution_등굣길 solution = new Solution_등굣길();
//		System.out.println(solution.solution(4, 3, new int[][] {{2, 2}}));
//		System.out.println(solution.solution(2, 2, new int[][] {}));
//		System.out.println(solution.solution(3, 3, new int[][] {}));
		System.out.println(solution.solution(3, 3, new int[][] {{2, 2}}));
		System.out.println(solution.solution(3, 3, new int[][] {{2, 3}}));
		System.out.println(solution.solution(3, 3, new int[][] {{1, 3}}));
	}
}
