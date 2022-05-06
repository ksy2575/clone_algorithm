package simulation;

public class Solution_3진법_뒤집기 {
	public int solution(int n) {
        String three = getThree(n);
        return getTen(three);
    }
	private String getThree(int n) {
		StringBuilder sb = new StringBuilder();
		while(n>0) {
			sb.append(n%3);
			n /= 3;
		}
		return sb.toString();
	}
	private int getTen(String three) {
		int ans = 0;
		int temp = 1;
		while(true) {
			ans += Character.getNumericValue(three.charAt(three.length()-1)) * temp;
			temp *= 3;
			if(three.length() == 1) break;
			three = three.substring(0, three.length()-1);
		}
		return ans;
	}
	public static void main(String[] args) {
		Solution_3진법_뒤집기 solution = new Solution_3진법_뒤집기();
		System.out.println(solution.solution(25));
	}
}
