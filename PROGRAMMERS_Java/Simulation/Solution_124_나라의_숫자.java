package lv2;


public class Solution_124_나라의_숫자 {
	
	public String solution(int n) {
    	int[] nums = new int[] {1, 2, 4};
    	long ans = 0;
    	long mul = 1;
    	long curr = 0;
        while(n != 0) {
        	curr = nums[(n-1)%3];
        	ans += curr*mul;
        	n = (n-1)/3;
        	mul *= 10;
        }
        
        return ans + "";
    }
	
	public static void main(String[] args) {
		Solution_124_나라의_숫자 solution = new Solution_124_나라의_숫자();
		System.out.println(solution.solution(500000000));
	}
}
