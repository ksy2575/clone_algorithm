package lv2;

//Brute Force
public class Solution_내적 {
	public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i = 0; i < a.length; i++) {
        	answer += a[i]*b[i];
        }
        return answer;
    }
	public static void main(String[] args) {
		Solution_내적 solution = new Solution_내적();
		System.out.println(solution.solution(new int[] {1,2,3,4}, new int[] {-3,-1,0,2}));
	}

}
