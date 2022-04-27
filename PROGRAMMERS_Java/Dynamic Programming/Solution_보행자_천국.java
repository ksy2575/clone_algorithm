package dp;

// DP
public class Solution_보행자_천국 {
	int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
    	print(cityMap);
    	int[][][] map = new int[m][n][2];
    	map[0][0][0] = 1;
    	map[0][0][1] = 1;
    	boolean[][][] visited = new boolean[m][n][2];
    	visited[0][0][0] = true;
    	visited[0][0][1] = true;
    	int answer = dp(cityMap, map, visited, m-1, n-1, 0) + dp(cityMap, map, visited, m-1, n-1, 1); // 왼쪽에서 온 거 + 오른쪽에서 온 거
    	System.out.println();
    	print(map);
        return answer/2 % MOD;
    }
	private int dp(int[][] cityMap, int[][][] map, boolean[][][] visited, int i, int j, int isLeft) {
//		if(i < 0 || j < 0) return 0;
		if(visited[i][j][isLeft]) return map[i][j][isLeft];
		
		// 아니라면
		visited[i][j][isLeft] = true;
		
		int temp = 0;
		
		if(isLeft == 0 && i-1 >= 0) { // 왼쪽에서 온 거 저장
			if(cityMap[i-1][j] == 0) {
				temp += dp(cityMap, map, visited, i-1, j, 0);
				temp += dp(cityMap, map, visited, i-1, j, 1);
			}else if(cityMap[i-1][j] == 2) {
				temp += dp(cityMap, map, visited, i-1, j, 0);
			}
		}else if(isLeft == 1 && j-1 >= 0) {
			if(cityMap[i][j-1] == 0) {
				temp += dp(cityMap, map, visited, i, j-1, 0);
				temp += dp(cityMap, map, visited, i, j-1, 1);
			}else if(cityMap[i][j-1] == 2) {
				temp += dp(cityMap, map, visited, i, j-1, 1);
			}
		}
		
		temp %= MOD;
		map[i][j][isLeft] = temp;
		
		return temp;
	}
	private void print(int[][][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print("[" + arr[i][j][0] + " " + arr[i][j][1] + "]");
			}
			System.out.println();
		}
	}
	private void print(int[][] cityMap) {
		for(int i = 0; i < cityMap.length; i++) {
			for(int j = 0; j < cityMap[0].length; j++) {
				System.out.print(cityMap[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Solution_보행자_천국 solution = new Solution_보행자_천국();
		System.out.println(solution.solution(3, 6, new int[][] {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}));
	}

}
