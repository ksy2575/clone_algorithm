package string;

public class Solution_가운데_글자_가져오기 {
	public String solution(String s) {
        return s.substring((s.length()+1)/2-1, s.length()/2+1);
    }
	public static void main(String[] args) {
		Solution_가운데_글자_가져오기 solution = new Solution_가운데_글자_가져오기();
		System.out.println(solution.solution("abcde"));
	}

}
