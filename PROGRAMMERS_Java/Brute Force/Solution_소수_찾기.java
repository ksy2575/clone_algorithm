package brute_force;

import java.util.HashSet;
import java.util.Set;

public class Solution_소수_찾기 {
	static int ans = 0;
	static Set<Integer> set = new HashSet<Integer>();
	public int solution(String numbers) {
        for(int i = 1; i <= numbers.length(); i++) {
        	System.out.println("i : " + i);
        	boolean[] visited = new boolean[numbers.length()];
        	permu(numbers, i, visited, 0, new StringBuilder());
        }
        return ans;
    }
	private void permu(String numbers, int i, boolean[] visited, int cnt, StringBuilder sb) {
		if(cnt == i && !set.contains(Integer.parseInt(sb.toString()))) {
			if(isSosu(Integer.parseInt(sb.toString()))) {
	        	System.out.println(Integer.parseInt(sb.toString()));
				set.add(Integer.parseInt(sb.toString()));
				ans++;
			}
			return;
		}
		for(int k = 0; k < numbers.length(); k++) {
			if(visited[k]) continue;
			visited[k] = true;
			permu(numbers, i, visited, cnt+1, sb.append(numbers.charAt(k)));
			sb.setLength(cnt);
			visited[k] = false;
		}
	}
	
	private boolean isSosu(int n) {
		if(n == 0 || n ==1) return false;
		for(int i = 2; i < n; i++) {
			if(n%i == 0) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Solution_소수_찾기 solution = new Solution_소수_찾기();
//		System.out.println(solution.solution("17"));
		System.out.println(solution.solution("011"));
	}

}
