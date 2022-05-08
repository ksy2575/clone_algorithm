package simulation;

import java.util.ArrayList;
import java.util.List;

public class Solution_같은_숫자는_싫어 {
	public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<Integer>();
        int pre = -1;
        for(int i = 0; i < arr.length; i++) {
        	if(arr[i] == pre) continue;
        	list.add(arr[i]);
        	pre = arr[i];
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
	public static void main(String[] args) {
		Solution_같은_숫자는_싫어 solution = new Solution_같은_숫자는_싫어();
		System.out.println(solution.solution(new int[] {1,1,3,3,0,1,1}));
	}

}
