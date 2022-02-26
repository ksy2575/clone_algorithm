package hash;

import java.util.HashMap;

public class Solution_완주하지_못한_선수 {
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String person : participant) {
        	map.put(person, map.getOrDefault(person, 0)+1);
        }
        for(String person : completion) {
        	map.put(person, map.get(person)-1);
        }
        for(String s : map.keySet()) {
        	if(map.get(s)==1) {
        		answer = s;
        		break;
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution_완주하지_못한_선수 solution = new Solution_완주하지_못한_선수();
		System.out.println(solution.solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
	}

}
