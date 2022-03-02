package sort;

import java.util.Arrays;
import java.util.Collections;

public class Solution_H_Index {
	public int solution(int[] citations) {
        int answer = 0;
        Integer[] c = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(c, Collections.reverseOrder());
        int remained = 0;
        for(int i=0; i<c.length;i++) {
        	remained = c.length-i-1;
        	int curr = Math.min(c[i], i+1);
        	while(curr >= remained && curr > answer) {
        		if(i+1 >= curr && curr >= remained) {
            		answer = curr;
            		break;
            	}else {
            		curr--;
            	}
        	}
        	
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution_H_Index solution = new Solution_H_Index();
//		System.out.println(solution.solution(new int[] {3, 0, 6, 1, 5})); // 6 5 3 1 0
		System.out.println(solution.solution(new int[] {2, 1, 0, 0, 0}));
	}

}
