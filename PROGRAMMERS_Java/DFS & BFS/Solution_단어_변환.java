package dfs_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_단어_변환 {
	
	public int solution(String begin, String target, String[] words) {
        return bfs(words, begin, target);
    }
	
	public int bfs(String[] words, String begin, String target) {
		int cnt = 0;
		String[] array = Arrays.copyOf(words, words.length+1);
		array[array.length-1] = begin;
		
		boolean[] visited = new boolean[array.length];
		
		Queue<int[]> q = new LinkedList<int[]>(); // {index, cnt};
		q.add(new int[] {array.length-1, 0});
		
		visited[array.length-1] = true;
		cnt++;
		
		while(cnt < array.length && !q.isEmpty()) { // 모든 인자 탐색 또는 스택이 빌 시 종료
			int[] currPop = q.poll();
			String curr = array[currPop[0]];
			for(int i = 0; i < array.length; i++) {
				if(visited[i]) continue;
				if(isPossible(curr, array[i])) {
					if(array[i].equals(target)) return currPop[1]+1;
					visited[i] = true;
					q.add(new int[] {i, currPop[1]+1});
					cnt++;
				}
			}
		}
		return 0;
	}
	

	public boolean isPossible(String curr, String next) {
		boolean flag = false;
		for(int i = 0; i < curr.length(); i++) {
			if(curr.charAt(i) != next.charAt(i)) {
				if(!flag) flag = true;
				else return false;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		Solution_단어_변환 solution = new Solution_단어_변환();
		System.out.println(solution.solution("hit", "cog",  new String[] {"hot", "dot", "dog", "lot", "log", "cog"})); // 4
	}
}
