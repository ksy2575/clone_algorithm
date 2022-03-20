package lv2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//String
public class Solution_뉴스_클러스터링 {
	
	public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<String, Integer> m1 = getElements(str1);
        Map<String, Integer> m2 = getElements(str2);

        
		int son = getSon(m1, m2);
		int mom = getMom(m1, m2);
        
        return mom==0?65536:(int)((double)son* 65536) / mom ;
    }
	
	public int getSon(Map<String, Integer> m1, Map<String, Integer> m2) {
		
		int retVal = 0;
		
		for(String curr : m1.keySet()) {
			if(m2.containsKey(curr)) {
				retVal += Math.min(m1.get(curr), m2.get(curr));
			}
		}
		
		return retVal;
	}
	public int getMom(Map<String, Integer> m1, Map<String, Integer> m2) {
		
		int retVal = 0;
		Set<String> tempSet = new HashSet<String>();
		
		for(String curr : m1.keySet()) {
			if(m2.containsKey(curr)) {
				retVal += Math.max(m1.get(curr), m2.get(curr));
			}else{
				retVal += m1.get(curr);
			}
			tempSet.add(curr);
		}
		for(String curr : m2.keySet()) {
			if(!tempSet.contains(curr)) {
				retVal += m2.get(curr);
			}
			tempSet.add(curr);
		}
		
		return retVal;
	}

	public Map<String, Integer> getElements(String str1) {
		Map<String, Integer> tempMap = new HashMap<String, Integer>();
		for(int i = 0; i < str1.length()-1; i++) {
			String curr = str1.substring(i, i+2);
			if(Character.isAlphabetic(curr.charAt(0)) && Character.isAlphabetic(curr.charAt(1))) {
				if(tempMap.putIfAbsent(curr, 1) != null) {
					tempMap.put(curr, tempMap.get(curr)+1);
				}
			}
		}
		return tempMap;
	}

	public static void main(String[] args) {
		Solution_뉴스_클러스터링 solution = new Solution_뉴스_클러스터링();
		System.out.println(solution.solution("FRANCE", "french"));
		System.out.println(solution.solution("handshake", "shake hands"));
		System.out.println(solution.solution("aa1+aa2", "AAAA12"));
		System.out.println(solution.solution("E=M*C^2", "e=m*c^2"));
	}
}
