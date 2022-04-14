package dp;

public class Solution_2_x_n_타일링 {
	public int solution(int n) {
        int[] dp = new int[n+3];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
        	dp[i] = (dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];
    }
	public static void main(String[] args) {
		Solution_2_x_n_타일링 solution = new Solution_2_x_n_타일링();
		System.out.println(solution.solution(100));
	}

}
