package lv2;

//brute force, dfs
public class Solution_카카오프렌즈_컬러링북 {
	static int[] di;
	static int[] dj;
	static int cnt;
	static int total;
	static int max;
	public int[] solution(int m, int n, int[][] picture) {
		di = new int[] {1, -1, 0, 0};
		dj = new int[] {0, 0, 1, -1};
		cnt = 0;
		total = 0;
		max = 0;
        
        find(m, n, picture);
        
        int[] answer =  new int[] {total, max};
        return answer;
    }
	
	private void find(int n, int m, int[][] picture) {
		
		boolean[][] visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(visited[i][j]) continue;
				if(picture[i][j] == 0) continue;
				visited[i][j] = true;
				cnt++;
				total++;
				dfs(i, j, visited, picture, n, m);
				if(cnt > max) max = cnt;
				cnt = 0;
			}
		}
		
	}

	private void dfs(int i, int j, boolean[][] visited, int[][] picture, int n, int m) {
		
		for(int k = 0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if(ni < 0 || ni >= n || nj < 0 || nj >= m) continue;
			if(visited[ni][nj]) continue;
			if(picture[ni][nj] != picture[i][j]) continue;
			visited[ni][nj] = true;
			cnt++;
			dfs(ni, nj, visited, picture, n, m);
		}
		
	}

	public static void main(String[] args) {
		Solution_카카오프렌즈_컬러링북 solution = new Solution_카카오프렌즈_컬러링북();
		System.out.println(solution.solution(6, 4, new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}}));
	}	// {4, 5}
}
