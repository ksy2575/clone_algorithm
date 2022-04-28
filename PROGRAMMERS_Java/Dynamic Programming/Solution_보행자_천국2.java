package dp;

// DP
public class Solution_보행자_천국2 {
	int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
//    	print(cityMap);
    	int[][][] map = new int[m+1][n+1][2];
    	
    	map[1][1][0] = map[1][1][1] = 1;
    	
    	for(int i = 1; i <= m; ++i) {
    		for(int j = 1; j <= n; ++j) {
        		if(cityMap[i-1][j-1] == 0) {
        			map[i][j][0] += (map[i-1][j][0] + map[i][j-1][1]) % MOD;
        			map[i][j][1] += (map[i-1][j][0] + map[i][j-1][1]) % MOD;
        			
        		}else if(cityMap[i-1][j-1] == 1) {
        			map[i][j][0] = 0;
        			map[i][j][1] = 0;
        		}else {
        			map[i][j][0] = map[i-1][j][0];
        			map[i][j][1] = map[i][j-1][1];
        		}
        	}
    	}
    	
    	System.out.println();
    	print(map);
        return map[m][n][0];
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
		Solution_보행자_천국2 solution = new Solution_보행자_천국2();
		System.out.println(solution.solution(3, 6, new int[][] {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}));
	}

}
