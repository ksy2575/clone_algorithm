package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_1260 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			if(map.get(s)==null) {
				HashSet<Integer> tempSet = new HashSet<Integer>();
				map.put(s, tempSet);
			}
			if(map.get(e)==null) {
				HashSet<Integer> tempSet = new HashSet<Integer>();
				map.put(e, tempSet);
			}
			map.get(s).add(e);
			map.get(e).add(s);
		}
		HashSet<Integer> dfsSet = new HashSet<Integer>();
		System.out.println(dfs(map, v, dfsSet).trim());
		System.out.println(bfs(map, v));
	}


	private static String dfs(HashMap<Integer, HashSet<Integer>> map, int v, HashSet<Integer> visited) {
		visited.add(v);
		StringBuffer s = new StringBuffer();
		s.append(" " + v);
		if(map.get(v)==null) {
			return s.toString();
		}
		ArrayList<Integer> currList = new ArrayList<Integer>(map.get(v));
		Collections.sort(currList);
		for(int i : currList) {
			if(!visited.contains(i)) {
				s.append(dfs(map, i, visited));
			}
		}
		return s.toString();
	}

	private static String bfs(HashMap<Integer, HashSet<Integer>> map, int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		q.add(v);
		visited.add(v);
		StringBuffer s = new StringBuffer();
		s.append(v);
		
		while(q.size() > 0) {
			v = q.poll();
			if(map.get(v)==null) {
				continue;
			}
			ArrayList<Integer> currList = new ArrayList<Integer>(map.get(v));
			Collections.sort(currList);
			for(int i : currList) {
				if(!visited.contains(i)) {
					q.offer(i);
					visited.add(i);
					s.append(" " + i);
				}
			}
		}
		
		
		return s.toString();
	}
}
