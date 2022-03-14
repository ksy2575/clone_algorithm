package dfs_bfs;

import java.util.HashSet;

public class Solution_네트워크 {
	
	public int solution(int n, int[][] computers) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i < n; i++) {
        	if(set.contains(i)) {
        		continue;
        	}
        	set.add(i);
        	dfs(computers, set, n, i);
        	answer++;
        }
        return answer;
    }
	
	public void dfs(int[][] computers, HashSet<Integer> set, int n, int curr) {
		
		for(int next = 0; next < n; next++) {
			if(curr==next) continue;
			if(set.contains(next)) continue;
			if(computers[curr][next] == 1) {
				set.add(next);
				dfs(computers, set, n, next);
			}
		}
		
	}

	public static void main(String[] args) {
		Solution_네트워크 solution = new Solution_네트워크();
		System.out.println(solution.solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})); // 2
//		System.out.println(solution.solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}})); // 1
	}
}
