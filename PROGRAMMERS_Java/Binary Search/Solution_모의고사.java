package binary_search;

import java.util.Arrays;

public class Solution_모의고사 {
	
	public long solution(int n, int[] times) {
		Arrays.sort(times);
		long left = 0;
		long right = (long)n*times[times.length-1];
		long mid = 0;
		long answer = 0;
		while(left <= right) {
			mid = (left + right)/2;
//			System.out.println(left + " " + mid + " " + right);
			long temp = 0;
			for(int time : times) {
				temp += mid/time;
			}
			if(temp >= n) {
				answer = mid;
//				System.out.println(answer);
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
        return answer;
    }
	
	public static void main(String[] args) {
		Solution_모의고사 solution = new Solution_모의고사();
//		System.out.println(solution.solution(6, new int[] {7, 10}));
//		System.out.println(solution.solution(10, new int[] {1, 2, 3, 4, 5}));
//		System.out.println(solution.solution(10, new int[] {6, 8, 10}));
//		System.out.println(solution.solution(3, new int[] {1, 1, 1}));
		System.out.println(solution.solution(3, new int[] {1, 2, 3}));
	}

}
