package lv2;

//Brute Force
public class Solution_없는_숫자_더하기 {
	public int solution(int[] numbers) {
        int answer = 45;
        for(int i : numbers) {
        	answer -= i;
        }
        return answer;
    }
	public static void main(String[] args) {
		Solution_없는_숫자_더하기 solution = new Solution_없는_숫자_더하기();
		System.out.println(solution.solution(new int[] {1,2,3,4,6,7,8,0}));
	}
}
