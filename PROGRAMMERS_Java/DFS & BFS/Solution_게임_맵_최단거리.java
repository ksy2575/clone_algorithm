package lv2;

import java.util.LinkedList;
import java.util.Queue;

// bfs
public class Solution_게임_맵_최단거리 {
	
	static int[] di = {0, 1, 0, -1};// 우, 하, 좌, 상
	static int[] dj = {1, 0, -1, 0};
	
	public int solution(int[][] maps) {
        return bfs(maps, 0, 0, maps.length, maps[0].length);
    }
	
	private int bfs(int[][] maps, int i, int j, int n, int m) {
		boolean[][] visited = new boolean[n][m];
		visited[i][j] = true;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {i, j, 1});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int k = 0; k < 4; k++) {
				int ni = curr[0] + di[k];
				int nj = curr[1] + dj[k];
				
				if(ni < 0 || ni >= n || nj < 0 || nj >= m) continue;
				if(visited[ni][nj] || maps[ni][nj] == 0) continue;
				
				if(ni == n-1 && nj == m-1) {
					return curr[2]+1;
				}
				
				visited[ni][nj] = true;
				q.add(new int[] {ni, nj, curr[2]+1});
			}
			
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution_게임_맵_최단거리 solution = new Solution_게임_맵_최단거리();
		System.out.println(solution.solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
	}
}
