package baekjoon.DFSnBFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Q_2606 {
	static int ret = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(!map.containsKey(a)) {
				map.put(a, new ArrayList<Integer>());
			}
			if(!map.containsKey(b)) {
				map.put(b, new ArrayList<Integer>());
			}
			map.get(a).add(b);
			map.get(b).add(a);
		}
//		System.out.println(map);
		boolean[] visited = new boolean[n+1];
		visited[1] = true;
		dfs(1, visited, map, 0);
		System.out.println(ret);
	}

	private static void dfs(int i, boolean[] visited, HashMap<Integer, ArrayList<Integer>> map, int cnt) {
		
		
		for(Integer curr : map.get(i)) {
			if(!visited[curr]) {
				visited[curr] = true;
				ret++;
				dfs(curr, visited, map, cnt+1);
			}
		}
		
	}

}
