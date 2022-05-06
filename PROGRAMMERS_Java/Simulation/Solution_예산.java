package simulation;

import java.util.Arrays;

public class Solution_예산 {
	public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int i = 0; i < d.length; i++) {
        	budget -= d[i];
        	answer++;
        	if(budget == 0) return answer;
        	if(budget < 0) return answer-1;
        }
        return answer;
    }
	public static void main(String[] args) {
		Solution_예산 solution = new Solution_예산();
		System.out.println(solution.solution(new int[] {1, 3, 2, 5, 4}, 9));
	}
}
