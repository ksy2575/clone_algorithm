package simulation;

// Simulation
public class Solution_삼각_달팽이 {
	static int max = 0;
	static int[] di = {1, 0, -1};
	static int[] dj = {0, 1, -1};
	public int[] solution(int n) {
		if(n == 1) return new int[] {1};
        int[][] arr = getArr(n);
        find(arr);
        return getAnswer(arr);
    }
	private int[] getAnswer(int[][] arr) {
		int[] answer = new int[max];
		int k = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				answer[k++] = arr[i][j];
			}
		}
		return answer;
	}
	private int[][] getArr(int n) {
		int[][] arr = new int[n][];
		for(int i = 0; i < n; i++) {
			arr[i] = new int[i+1];
			max += i+1;
		}
		return arr;
	}
	private void find(int[][] arr) {
		int si = 0;
		int sj = 0;
		int k = 0;
		int n = 1;
		while(true) {
			arr[si][sj] = n++;
			int ni = si + di[k];
			int nj = sj + dj[k];
			if(ni < 0 || ni >= arr.length || nj < 0 || nj >= arr[si].length || arr[ni][nj] != 0) {
				k = (k+1)%3;
				ni = si + di[k];
				nj = sj + dj[k];
			}
			si = ni;
			sj = nj;
			if(arr[ni][nj] != 0) break;
			
		}
	}
	public static void main(String[] args) {
		Solution_삼각_달팽이 solution = new Solution_삼각_달팽이();
		System.out.println(solution.solution(1));
	}

}
