package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution_가장_먼_노드 {
	
	public int solution(int n, int[][] edge) {
        // 인접 행렬, 인접 리스트
        
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for(int[] line : edge) {
        	if(!map.containsKey(line[0])) map.put(line[0], new HashSet<Integer>());
        	if(!map.containsKey(line[1])) map.put(line[1], new HashSet<Integer>());
        	map.get(line[0]).add(line[1]);
        	map.get(line[1]).add(line[0]);
        }
        
        return bfs(n, new boolean[n+1], map);
    }
	
	public int bfs(int n, boolean[] visited, Map<Integer, Set<Integer>> map) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {1, 0});
		visited[1] = true;
		
		int cnt = 0;
		int value = 0;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			if(curr[1] > value) {
				value = curr[1];
				cnt = 1;
			}else if(curr[1] == value) {
				cnt++;
			}
			for(int next : map.get(curr[0])) {
				if(visited[next]) continue;
				visited[next] = true;
				q.add(new int[] {next, curr[1]+1});
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Solution_가장_먼_노드 solution = new Solution_가장_먼_노드();
		System.out.println(solution.solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}})); // 3
	}

}
