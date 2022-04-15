package dfs_bfs;

import java.util.regex.Pattern;

//DFS
public class Solution_불량_사용자 {
	static boolean[] ban_visited = new boolean[256];
	public int solution(String[] user_id, String[] banned_id) {
        return dfs(user_id, banned_id, new boolean[user_id.length], 0, 0);
    }
	private int dfs(String[] user_id, String[] banned_id, boolean[] visited, int index, int cnt) {
		if(cnt == banned_id.length) {
			int curr = getBinaryFromVisited(visited); 
			if(ban_visited[curr]) {
				return 0;
			}else {
				ban_visited[curr] = true;
				return 1;
			}
		}
		if(index > banned_id.length) return 0;
		
		int temp = 0;
		for(int i = 0; i < visited.length; i++) {
			if(visited[i]) continue;
			if(Pattern.matches(getPattern(banned_id[index]), user_id[i])) {
				visited[i] = true;
				temp += dfs(user_id, banned_id, visited, index+1, cnt+1);
				visited[i] = false;
			}
		}
		return temp;
	}
	private int getBinaryFromVisited(boolean[] visited) {
		int temp = 0;
		for(int i = 0; i < visited.length; i++) {
			temp *= 2;
			temp += visited[i]?1:0;
		}
		return temp;
	}
	private String getPattern(String s) {
		StringBuilder sb = new StringBuilder();
		for(char c : s.toCharArray()) {
			if(c == '*') {
				sb.append(".");
			}else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		Solution_불량_사용자 solution = new Solution_불량_사용자();
//		System.out.println(solution.solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}
//		, new String[] {"fr*d*", "abc1**"}));
		System.out.println(solution.solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}
		, new String[] {"*rodo", "*rodo", "******"}));
	}

}
