package dfs_bfs;

public class Solution_타겟_넘버 {
	public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
	
	public int dfs(int[] numbers, int target, int i, int total) {
		if(i == numbers.length) {
			return total == target ? 1 : 0;
		}
		int curr = numbers[i];
		
		return dfs(numbers, target, i+1, total+curr) + dfs(numbers, target, i+1, total-curr);
	}
	public static void main(String[] args) {
		Solution_타겟_넘버 solution = new Solution_타겟_넘버();
		System.out.println(solution.solution(new int[] {1, 1, 1, 1, 1}, 3));
//		System.out.println(solution.solution(new int[] {4, 1, 2, 1}, 4));
	}
}
