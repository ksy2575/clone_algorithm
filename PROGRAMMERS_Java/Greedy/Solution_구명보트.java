package gready;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution_구명보트 {
	public int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> l1 = new ArrayList<Integer>();
        for(int n : people) {
        	l1.add(n);
        }
        l1.sort(Comparator.reverseOrder());
        int left = 0;
        int right = l1.size()-1;
        while(left <= right) {
        	if(l1.get(left)+l1.get(right) <= limit) {
        		left++;
        		right--;
        	}else {
        		left++;
        	}
        	answer++;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution_구명보트 solution = new Solution_구명보트();
		System.out.println(solution.solution(new int[] {70, 50, 80, 50}, 100));
	}

}
