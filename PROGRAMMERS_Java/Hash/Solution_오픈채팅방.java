package lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//Hash
public class Solution_오픈채팅방 {
	public String[] solution(String[] record) {
        // Map<uid1234, Muzi>, <uid4567, Prodo>로 생성
        // Queue에 기록 저장
        // 닉네임 변경 시 반영
        Map<String, String> nicknames = new HashMap<String, String>();
        Queue<String[]> chat = new LinkedList<String[]>();
        for(String s : record) {
        	String[] curr = s.split(" ");
        	if(curr[0].equals("Enter")) {
        		nicknames.put(curr[1], curr[2]);
        		chat.add(new String[] {curr[1], "님이 들어왔습니다."});
        	}else if(curr[0].equals("Leave")) {
        		chat.add(new String[] {curr[1], "님이 나갔습니다."});
        		
        	}else {
        		nicknames.put(curr[1], curr[2]);
        	}
        }
        List<String> answer = new ArrayList<String>();
        while(!chat.isEmpty()) {
        	String[] curr = chat.poll();
        	answer.add(nicknames.get(curr[0]) + curr[1]);
        }
        return answer.toArray(new String[answer.size()]);
    }
	
	public static void main(String[] args) {
		Solution_오픈채팅방 solution = new Solution_오픈채팅방();
		System.out.println(solution.solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}));
	}
}
