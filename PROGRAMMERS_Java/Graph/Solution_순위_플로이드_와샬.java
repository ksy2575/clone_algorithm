package graph;

// Graph, 플로이드 와샬
public class Solution_순위_플로이드_와샬 {
	
	public int solution(int n, int[][] results) {
		int answer = 0;
		int[][] arr = new int[n+1][n+1];
		for(int[] result : results) {
			arr[result[0]][result[1]] = 1;
			arr[result[1]][result[0]] = -1;
		}
		
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(arr[i][k] == 1 && arr[k][j] == 1) arr[i][j] = 1;
					if(arr[i][k] == -1 && arr[k][j] == -1) arr[i][j] = -1;
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			int cnt = 0;
			for(int j = 1; j <= n; j++) {
				cnt += Math.abs(arr[i][j]);
			}
			if(cnt == n-1) answer++;
		}
		
		return answer;
    }
	

	public static void main(String[] args) {
		Solution_순위_플로이드_와샬 solution = new Solution_순위_플로이드_와샬();
		System.out.println(solution.solution(5, new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}})); // 2
	}

}
