package lv2;

import java.util.HashMap;
import java.util.Map;

//String
public class Solution_숫자_문자열과_영단어 {
	public int solution(String s) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("zero", 0);
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
        	if(Character.isDigit(c)) {
        		answer *= 10;
        		answer += Character.getNumericValue(c);
        		continue;
        	}
        	sb.append(c);
        	if(map.containsKey(sb.toString())) {
        		answer *= 10;
        		answer += map.get(sb.toString());
        		sb = new StringBuilder();
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		Solution_숫자_문자열과_영단어 solution = new Solution_숫자_문자열과_영단어();
		System.out.println(solution.solution("one4seveneight"));
	}

}
