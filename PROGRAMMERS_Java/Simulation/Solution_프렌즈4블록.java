package simulation;

//Simulation, Brute Force
public class Solution_프렌즈4블록 {
	public int solution(int m, int n, String[] board) {
		char[][] arr = getArray(m, n, board);
		return find(m, n, arr);
    }
	private int find(int m, int n, char[][] arr) {
		int cnt = 0;
		while(true) {
			boolean[][] visited = new boolean[m][n];
			for(int i = 0; i < m-1; i++) {
				for(int j = 0; j < n-1; j++) {
					if(isSquare(i, j, m, n, arr)) {
						visited[i][j] = true;
						visited[i][j+1] = true;
						visited[i+1][j] = true;
						visited[i+1][j+1] = true;
					}
				}
			}
			int temp = removeSquare(m, n, arr, visited);
			setArray(m, n, arr);
			if(temp == 0) break;
			cnt += temp;
		}
		return cnt;
	}

	private boolean isSquare(int i, int j, int m, int n, char[][] arr) {
		if(i >= m-1 || j >= n-1) return false;
		if(arr[i][j] == '0') return false;
		if(arr[i][j] == arr[i][j+1] && arr[i][j] == arr[i+1][j] && arr[i][j] == arr[i+1][j+1]) return true;
		return false;
	}

	private int removeSquare(int m, int n, char[][] arr, boolean[][] visited) {
		int cnt = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(visited[i][j]) {
					arr[i][j] = '0';
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	private void setArray(int m, int n, char[][] arr) {
		for(int j = 0; j < n; j++) {
			line : for(int i = m-1; i >= 0; i--) {
				if(arr[i][j] == '0') {
					int curr = i-1;
					while(curr >= 0) {
						if(arr[curr][j] != '0') {
							arr[i][j] = arr[curr][j];
							arr[curr][j] = '0';
							continue line;
						}
						curr--;
					}
					break;
				}
			}
		}
	}
	
	private char[][] getArray(int m, int n, String[] board) {
		char[][] arr = new char[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n;j++) {
				arr[i][j] = board[i].charAt(j);
			}
		}
		return arr;
	}
	private void print(char[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Solution_프렌즈4블록 solution = new Solution_프렌즈4블록();
//		System.out.println(solution.solution(4, 5, new String[] {"CCBDE", "AAADE", "AAABF", "CCBBF"}));
		System.out.println(solution.solution(4, 12, new String[] {"CCAAABACDBDE", "AAAABCADADEE", "AAADBACCDBFF", "CCBAABDFDDFF"}));
	}
}
