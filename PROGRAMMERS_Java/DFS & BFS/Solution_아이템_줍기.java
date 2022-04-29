package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_아이템_줍기 {
	static int[] di = new int[] {0, 0, 1, -1};
	static int[] dj = new int[] {1, -1, 0, 0};
	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] arr = new boolean[51][51];
        for(int[] rec : rectangle) {
        	fill(arr, rec);
        }
        print(arr);
        return bfs(arr, characterX, characterY, itemX, itemY);
    }
	private int bfs(boolean[][] arr, int characterX, int characterY, int itemX, int itemY) {
		boolean[][] visited = new boolean[51][51];
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {characterY, characterX, 0});
		visited[characterY][characterX] = true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			System.out.println(curr[0] + " " + curr[1] + " > " + curr[2]);
			if(curr[0] == itemY && curr[1] == itemX) {
				System.out.println("finished");
				return curr[2];
			}
			for(int k = 0; k < 4; k++) {
				int ni = curr[0] + di[k];
				int nj = curr[1] + dj[k];
				if(!arr[ni][nj]) continue;
				if(visited[ni][nj]) continue;
				if(ni < 1 || ni >= 51 || nj < 1 || nj >= 51) continue;
				if(isEdge(arr, ni, nj)) {
					visited[ni][nj] = true;
					q.add(new int[] {ni, nj, curr[2]+1});
				}
			}
		}
		return 0;
	}
	private boolean isEdge(boolean[][] arr, int ni, int nj) {//밖으로 꺾이는 부분은 어떻게?
		int cnt = 0;
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				cnt += arr[ni + i][nj + j]?1:0;
			}
		}
		return cnt == 9 ? false : true;
	}
	private void print(boolean[][] arr) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(arr[i][j]?1:0);
			}
			System.out.println();
		}
	}
	private void fill(boolean[][] arr, int[] rec) {
		for(int i = rec[1]; i <= rec[3]; i++) {
			for(int j = rec[0]; j <= rec[2]; j++) {
				arr[i][j] = true;
			}
		}
	}
	public static void main(String[] args) {
		Solution_아이템_줍기 solution = new Solution_아이템_줍기();
		System.out.println(solution.solution(new int[][] {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}}, 1, 3, 7, 8));
//		System.out.println(solution.solution(new int[][] {{1, 1, 5, 7}}, 1, 1, 4, 7));
	}

}
