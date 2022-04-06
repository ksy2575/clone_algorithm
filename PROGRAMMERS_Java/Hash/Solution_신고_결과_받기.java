package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//hash
public class Solution_신고_결과_받기 {
	public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> singoMap = new HashMap<String, Set<String>>(); // 누가 누구들을 신고했다
        Map<String, Set<String>> singoMap2 = new HashMap<String, Set<String>>(); // 누가 누구들한테 신고당했다
        Map<String, Integer> cntMap = new HashMap<String, Integer>(); // 누가 얼마나 신고당했다
        Map<String, Integer> cntMap2 = new HashMap<String, Integer>(); // 누가 신고메시지를 잘 받았다
        
        for(String s : report) {
        	String[] ss = s.split(" ");
        	
        	if(!singoMap.getOrDefault(ss[0], new HashSet<String>()).contains(ss[1])) {
            	cntMap.putIfAbsent(ss[1], 0);
            	cntMap.put(ss[1], cntMap.get(ss[1])+1);
        	}
        	
        	singoMap.putIfAbsent(ss[0], new HashSet<String>());
        	singoMap.get(ss[0]).add(ss[1]);
        	
        	
        	singoMap2.putIfAbsent(ss[1], new HashSet<String>());
        	singoMap2.get(ss[1]).add(ss[0]);
        	
        }
        
        for(String curr : cntMap.keySet()) {
        	if(cntMap.get(curr) >= k) {
        		for(String p : singoMap2.get(curr)) {
        			cntMap2.putIfAbsent(p, 0);
        			cntMap2.put(p, cntMap2.get(p)+1);
        		}
        	}
        }
        
        for(int i = 0; i < id_list.length; i++) {
        	answer[i] = cntMap2.getOrDefault(id_list[i], 0);
        }
        return answer;
    }
	public static void main(String[] args) {
		Solution_신고_결과_받기 solution = new Solution_신고_결과_받기();
		System.out.println(solution.solution(new String[] {"muzi", "frodo", "apeach", "neo"}
		, new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2)); // 2 1 1 0
	}
}
