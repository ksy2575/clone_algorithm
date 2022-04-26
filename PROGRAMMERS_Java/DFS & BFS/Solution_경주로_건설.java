package dfs_bfs;

// DFS, BackTracking
public class Solution_경주로_건설 {
	static int min = Integer.MAX_VALUE;
	static int[] di = new int[] {0, 1, 0, -1};
	static int[] dj = new int[] {1, 0, -1, 0};
	public int solution(int[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int[][][] costs = new int[board.length][board[0].length][4];
        visited[0][0] = true;
        dfs(board, 0, 0, visited, costs, 1, 0);
        dfs(board, 0, 0, visited, costs, 0, 0);
        return min;
    }
	private void dfs(int[][] board, int i, int j, boolean[][] visited, int[][][] costs, int dir, int total) {
		costs[i][j][dir] = total;
		if(i == board.length-1 && j == board[0].length-1) {
			min = Math.min(min, total);
			return;
		}
		for(int k = 0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if(ni < 0 || ni >= board.length || nj < 0 || nj >= board[0].length) continue;
			if(board[ni][nj] == 1) continue;
			if(visited[ni][nj]) continue;
			if(costs[ni][nj][k] != 0 && costs[ni][nj][k] < total + (k%4==dir%4?100:600)) continue;
			visited[ni][nj] = true;
			dfs(board, ni, nj, visited, costs, k, total + (k%4==dir%4?100:600));
			visited[ni][nj] = false;
		}
	}
	public static void main(String[] args) {
		Solution_경주로_건설 solution = new Solution_경주로_건설();
		System.out.println(solution.solution(new int[][] {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}}));
	}//3200

}
