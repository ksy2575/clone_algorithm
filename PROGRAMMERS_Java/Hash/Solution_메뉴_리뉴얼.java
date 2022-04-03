package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//combination, hash
public class Solution_메뉴_리뉴얼 {
	
	public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String order : orders) {
        	String[] chars = order.split("");
        	Arrays.sort(chars);
        	order = String.join("", chars);
        	for(int i = 2; i <= order.length(); i++) {
        		combi(map, order, -1, i, "");
        	}
        }
        System.out.println(map);
        return find(map, course);
    }
	
	public String[] find(Map<String, Integer> map, int[] course) {
		Map<Integer, Set<String>> retMap = new HashMap<Integer, Set<String>>();
		int[] cnts = new int[11];
		for(String curr : map.keySet()) {
			if(!isIn(course, curr)) continue;
			int n = map.get(curr);
			if(n > 1) {
				retMap.putIfAbsent(curr.length(), new HashSet<String>());
				if(cnts[curr.length()] < n) {
					retMap.get(curr.length()).clear();
					cnts[curr.length()] = n;
				}
				if(cnts[curr.length()] <= n) {
					retMap.get(curr.length()).add(curr);
				}
			}
		}
		List<String> ansList = new ArrayList<String>();
		for(int i : retMap.keySet()) {
			
			// i를 리스트에 다 받아
			
//			for(String curr : retMap.get(i)) {
//				ansList.add(curr);
//			}
		}
		
		//그 리스트를 sort
		
		ansList.sort(Comparator.naturalOrder());
		return ansList.toArray(new String[ansList.size()]);
	}

	public boolean isIn(int[] course, String curr) {
		for(int i : course) {
			if(curr.length() == i) return true;
		}
		return false;
	}

	private void combi(Map<String, Integer> map, String order, int pre, int cnt, String string) {
		if(cnt == 0) {
			Integer curr = map.putIfAbsent(string, 0);
			map.put(string, (curr==null?0:curr)+1);
			return;
		}
		for(int i = pre+1; i < order.length(); i++) {
			combi(map, order, i, cnt-1, string+String.valueOf(order.charAt(i)));
		}
	}

	public static void main(String[] args) {
		Solution_메뉴_리뉴얼 solution = new Solution_메뉴_리뉴얼();
//		System.out.println(solution.solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2, 3, 4}));
		// "AC", "ACDE", "BCFG", "CDE"
//		System.out.println(solution.solution(new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[] {2, 3, 5}));
		// "ACD", "AD", "ADE", "CD", "XYZ"
		System.out.println(solution.solution(new String[] {"XYZ", "XWY", "WXA"}, new int[] {2, 3, 4}));
		//["WX", "XY"]
	}
}
