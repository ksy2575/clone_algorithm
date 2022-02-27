package hash;

import java.util.HashMap;
import java.util.HashSet;

public class Solution_위장 {
	public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
        for(String[] cloth : clothes) {
        	String name = cloth[0];
        	String kind = cloth[1];
        	if(!map.containsKey(kind)) {
        		map.put(kind, new HashSet<String>());
        	}
        	map.get(kind).add(name);
        }
        for(HashSet<String> set : map.values()) {
        	answer *= (set.size()+1);
        }
        return answer-1;
    }
	
	public static void main(String[] args) {
		Solution_위장 solution = new Solution_위장();
		System.out.println(solution.solution(new String[][] {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
	}

}
