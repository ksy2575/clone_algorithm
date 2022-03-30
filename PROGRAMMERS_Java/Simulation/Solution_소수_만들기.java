package simulation;

//combination
public class Solution_소수_만들기 {
	static int answer = 0;
	public int solution(int[] nums) {
        combi(nums, -1, 0, 0);
        return answer;
    }

	private void combi(int[] nums, int i, int cnt, int total) {
		if(cnt == 3) {
			System.out.println(total);
			if(isSosu(total)) answer ++;
			return;
		}
		for(int k = i+1; k < nums.length; k++) {
			combi(nums, k, cnt+1, total+nums[k]);
		}
	}

	private boolean isSosu(int total) {
		for(int i = 2; i <= Math.sqrt(total); i++) {
			if(total%i == 0) return false;
		}
		System.out.println("good" + total);
		return true;
	}

	public static void main(String[] args) {
		Solution_소수_만들기 solution = new Solution_소수_만들기();
		System.out.println(solution.solution(new int[] {1,2,3,4}));//1
//		System.out.println(solution.solution(new int[] {1,2,7,6,4}));//4
	}
}
