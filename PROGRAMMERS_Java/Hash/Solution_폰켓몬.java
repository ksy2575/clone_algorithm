package hash;

import java.util.HashSet;
import java.util.Set;

// Hash
public class Solution_폰켓몬 {
	public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int n : nums) {
        	set.add(n);
        }
        return Math.min(set.size(), nums.length/2);
    }
	public static void main(String[] args) {
		Solution_폰켓몬 solution = new Solution_폰켓몬();
		System.out.println(solution.solution(new int[] {3, 1, 2, 3}));
	}

}
