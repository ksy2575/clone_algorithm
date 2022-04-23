package simulation;

import java.util.HashSet;
import java.util.Set;

// Simulation, Hash
public class Solution_영어_끝말잇기 {
	public int[] solution(int n, String[] words) {
        int[] answer = {};
        Set<String> set = new HashSet<String>();
        int curr = 1;
        String pre = "";
        for(String word : words) {
        	if((!pre.equals("") && word.charAt(0) != pre.charAt(pre.length()-1)) || set.contains(word)) {
        		return new int[] {curr%n == 0? n : curr%n, (curr/n) + (curr%n > 0? 1 : 0)};
        	}
        	set.add(word);
        	pre = word;
        	curr++;
        }
        return new int[] {0, 0};
    }
	public static void main(String[] args) {
		Solution_영어_끝말잇기 solution = new Solution_영어_끝말잇기();
//		System.out.println(solution.solution(3, new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}));
		System.out.println(solution.solution(2, new String[] {"hello", "one", "even", "never", "now", "world", "draw"}));
	}

}
