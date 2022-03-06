package gready;

import java.util.HashSet;

public class Solution_섬_연결하기 {
	static int answer = 0;
	
	public int solution(int n, int[][] costs) {
        int[][] road = new int[n][n];
        
        for(int[] cost : costs) {
        	road[cost[0]][cost[1]] = cost[2];
        	road[cost[1]][cost[0]] = cost[2];
        }
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(0);
        find(road, set, 1);
        
        return answer;
    }
	public void find(int[][] road, HashSet<Integer> set, int cnt) {
		
		if(cnt == road.length) return;
		
		int nextIsland = 0;
		int	min = Integer.MAX_VALUE;
		
		for(int curr : set) {
			for(int next = 0; next < road.length; next++) {
				if(curr==next || set.contains(next)) continue;
				int value = road[curr][next];
				if(value == 0) continue;
				if(value < min) {
					nextIsland = next;
					min = value;
				}
			}
		}
		set.add(nextIsland);
		answer += min;
		find(road, set, cnt+1);
	}
	public static void main(String[] args) {
		Solution_섬_연결하기 solution = new Solution_섬_연결하기();
		System.out.println(solution.solution(4, new int[][] {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
	}

}
