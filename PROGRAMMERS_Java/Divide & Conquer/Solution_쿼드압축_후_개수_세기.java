package divide_and_conquer;

// Divide & Conquer
public class Solution_쿼드압축_후_개수_세기 {
	public int[] solution(int[][] arr) {
        return cut(arr, 0, 0, arr.length);
    }
	private int[] cut(int[][] arr, int i, int j, int len) {
		if(len == 1) {
			return new int[] {arr[i][j]==0?1:0, arr[i][j]==1?1:0};
		}
		int[] total = new int[2];
		int[] temp = cut(arr, i, j, len/2);
		total[0] += temp[0];
		total[1] += temp[1];
		temp = cut(arr, i, j+len/2, len/2);
		total[0] += temp[0];
		total[1] += temp[1];
		temp = cut(arr, i+len/2, j, len/2);
		total[0] += temp[0];
		total[1] += temp[1];
		temp = cut(arr, i+len/2, j+len/2, len/2);
		total[0] += temp[0];
		total[1] += temp[1];
		
		if(total[0] == 4 && total[1] == 0) total[0] = 1;
		if(total[0] == 0 && total[1] == 4) total[1] = 1;
		return total;
	}
	public static void main(String[] args) {
		Solution_쿼드압축_후_개수_세기 solution = new Solution_쿼드압축_후_개수_세기();
		System.out.println(solution.solution(new int[][] {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}}));
	}

}
