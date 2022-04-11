package simulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Simulation, Sliding window
public class Solution_보석_쇼핑 {
	public int[] solution(String[] gems) {
        int[] answer;
        Set<String> set = new HashSet<String>();
        for(String curr : gems) {
        	set.add(curr);
        }
        answer = find(gems, set);
        System.out.println(set);
        return answer;
    }
	private int[] find(String[] gems, Set<String> set) {
		int[] retArr = new int[2];
		int l = 0;
		int r = 0;
		int min = Integer.MAX_VALUE;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put(gems[0], 1);
		while(true) {
			System.out.println(map);
			if(map.size() == set.size()) {
				if(r-l < min) {
					min = r-l;
					retArr[0] = l+1;
					retArr[1] = r+1;
					System.out.println(Arrays.toString(retArr));
				}
				if(map.get(gems[l]) == 1) map.remove(gems[l]);
				else map.put(gems[l], map.get(gems[l])-1);
				l++;
			}else {
				if(r == gems.length-1) break;
				r++;
				map.put(gems[r], map.getOrDefault(gems[r], 0)+1);
			}
		}
		return retArr;
	}
	public static void main(String[] args) {
		Solution_보석_쇼핑 solution = new Solution_보석_쇼핑();
		System.out.println(solution.solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}));
	}

}
