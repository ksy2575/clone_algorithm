package brute_force;

import java.util.ArrayList;
import java.util.List;

public class Solution_모의고사 {
	static final int[][] array = {
			{1, 2, 3, 4, 5},
			{2, 1, 2, 3, 2, 4, 2, 5},
			{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
			};
	public int[] solution(int[] answers) {
		int[] scores = {0, 0, 0};
		for(int i=0; i<answers.length;i++) {
			int curr = answers[i];
			for(int j = 0; j < 3; j++) {
				if(array[j][i%array[j].length]==curr) {
					scores[j]++;
				}
			}
		}
		int max = 0;
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i < scores.length;i++) {
			if(scores[i] > max) {
				max = scores[i];
				list.clear();
				list.add(i+1);
			}else if(scores[i] == max) {
				list.add(i+1);
			}
		}
		System.out.println(list);
        return list.stream().mapToInt(x->x).toArray();
    }
	
	public static void main(String[] args) {
		Solution_모의고사 solution = new Solution_모의고사();
		System.out.println(solution.solution(new int[] {1, 2, 3, 4, 5}));
	}

}
