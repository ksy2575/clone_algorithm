package lv2;

//Brute Force
public class Solution_음양_더하기 {
	public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < signs.length; i++) {
        	answer += signs[i]?absolutes[i]:-absolutes[i];
        }
        return answer;
    }
	public static void main(String[] args) {
		Solution_음양_더하기 solution = new Solution_음양_더하기();
		System.out.println(solution.solution(new int[] {4,7,12}, new boolean[] {true, false, true}));
	}

}
