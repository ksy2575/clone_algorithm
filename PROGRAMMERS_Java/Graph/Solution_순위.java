package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_순위 {
	
	public int solution(int n, int[][] results) {
		int cnt = 0;
        // {4, 3} > 4가 3을 이겼다. -> Map<Integer, Set>으로 이긴 목록, 진 목록 갖고 있기. 부가적인 요소도 처리하기
		Map<Integer, Set<Integer>> wins = new HashMap<Integer, Set<Integer>>();
		Map<Integer, Set<Integer>> loses = new HashMap<Integer, Set<Integer>>();
		for(int i = 1; i <= n; i++) {
			wins.put(i, new HashSet<Integer>());
			loses.put(i, new HashSet<Integer>());
		}
		for(int[] result : results) {
//			System.out.println(result[0] + " : " + result[1]);
			putWin(wins, loses, result[0], result[1]); // 4 > 3
			putLose(wins, loses, result[1], result[0]); // 3 < 4
		}
//		System.out.println(wins);
//		System.out.println(loses);
		for(int i = 1; i <= n; i++) {
			if(wins.get(i).size() + loses.get(i).size() == n-1) cnt++;
		}
		return cnt;
    }
	

	public void putWin(Map<Integer, Set<Integer>> wins, Map<Integer, Set<Integer>> loses, int a, int b) {
		wins.get(a).add(b);
//		System.out.println(a + "가 " + b + "를 이김");
		for(int loser : wins.get(b)) {
			if(!wins.get(a).contains(loser)) putWin(wins, loses, a, loser);
			if(!loses.get(loser).contains(a)) putLose(wins, loses, loser, a);
		}
	}
	public void putLose(Map<Integer, Set<Integer>> wins, Map<Integer, Set<Integer>> loses, int a, int b) {
		loses.get(a).add(b);
//		System.out.println(a + "가 " + b + "한테 짐");
		for(int winner : loses.get(b)) {
			if(!loses.get(a).contains(winner)) putLose(wins, loses, a, winner);
			if(!wins.get(winner).contains(a)) putWin(wins, loses, winner, a);
		}
	}



	public void find(Map<Integer, Set> wins, Map<Integer, Set> loses, int[] result) {
		
	}


	public static void main(String[] args) {
		Solution_순위 solution = new Solution_순위();
		System.out.println(solution.solution(5, new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}})); // 2
	}

}
