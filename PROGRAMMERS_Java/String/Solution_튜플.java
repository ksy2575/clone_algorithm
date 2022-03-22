package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//String
public class Solution_튜플 {
	public int[] solution(String s) {
        s = s.substring(1, s.length()-1);
        
        List<String> list = new ArrayList<String>();
        
        for(String curr : s.split("},")) {
        	curr = curr.substring(1);
        	if(curr.charAt(curr.length()-1) == '}') {
        		curr = curr.substring(0, curr.length()-1);
        	}
        	list.add(curr);
        }
        
        list.sort((first, second) -> first.length()-second.length());
        List<Integer> ansList = new ArrayList<Integer>();
        
        for(int i = 0; i < list.size(); i++) {
        	int[] temp = Arrays.stream(list.get(i).split(",")).mapToInt(Integer::parseInt).toArray();
        	for(int n : temp) {
        		if(ansList.contains(n)) continue;
        		ansList.add(n);
        	}
        }
        
        return ansList.stream().mapToInt(x->(int)x).toArray();
    }
	
	public static void main(String[] args) {
		Solution_튜플 solution = new Solution_튜플();
//		System.out.println(solution.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
		System.out.println(solution.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"));
	}
}
