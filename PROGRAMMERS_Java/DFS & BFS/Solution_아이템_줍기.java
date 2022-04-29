package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

// BFS
public class Solution_아이템_줍기 {
	static int[] di = new int[] {0, 0, 1, -1};
	static int[] dj = new int[] {1, -1, 0, 0};
	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] arr = new boolean[102][102];
        for(int[] rec : rectangle) {
        	fill(arr, rec);
        }
        return bfs(arr, characterX*2, characterY*2, itemX*2, itemY*2);
    }
	private int bfs(boolean[][] arr, int characterX, int characterY, int itemX, int itemY) {
		boolean[][] visited = new boolean[102][102];
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {characterY, characterX, 0});
		visited[characterY][characterX] = true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			if(curr[0] == itemY && curr[1] == itemX) return curr[2]/2;
			for(int k = 0; k < 4; k++) {
				int ni = curr[0] + di[k];
				int nj = curr[1] + dj[k];
				if(!arr[ni][nj]) continue;
				if(visited[ni][nj]) continue;
				if(ni < 2 || ni > 100 || nj < 2 || nj > 100) continue;
				if(isEdge(arr, ni, nj)) {
					visited[ni][nj] = true;
					q.add(new int[] {ni, nj, curr[2]+1});
				}
			}
		}
		return 0;
	}
	private boolean isEdge(boolean[][] arr, int ni, int nj) {
		int cnt = 0;
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				cnt += arr[ni + i][nj + j]?1:0;
			}
		}
		return cnt == 9 ? false : true;
	}
	private void fill(boolean[][] arr, int[] rec) {
		for(int i = rec[1]*2; i <= rec[3]*2; i++) {
			for(int j = rec[0]*2; j <= rec[2]*2; j++) {
				arr[i][j] = true;
			}
		}
	}
	public static void main(String[] args) {
		Solution_아이템_줍기 solution = new Solution_아이템_줍기();
//		System.out.println(solution.solution(new int[][] {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}}, 1, 3, 7, 8));
		System.out.println(solution.solution(new int[][] {{1, 1, 5, 7}}, 1, 1, 4, 7));
	}

}
