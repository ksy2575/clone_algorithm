package baekjoon.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q_1647 {
	static class Line implements Comparable<Line>{
		int v;
		int s;
		int e;
		public Line(int v, int s, int e) {
			this.v = v;
			this.s = s;
			this.e = e;
		}
		@Override
		public int compareTo(Line o) {
			return this.v-o.v;
		}
	}
	
	static PriorityQueue<Line> pq = new PriorityQueue<Line>();
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long total = 0;
		int last_line = 0;
		int cnt = 0;
		parent = new int[n+1];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		
		ArrayList<Line> lines = new ArrayList<Line>();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new Line(c, a, b));
			lines.add(new Line(c, a, b));
		}
		
		
//		Collections.sort(lines);
		
//		for(Line curr : lines) {
//			if(cnt == n-1) break;
//			int v = curr.v;
//			int s = curr.s;
//			int e = curr.e;
//			if(find_parent(s) == find_parent(e)) {
//				continue;
//			}else {
//				union(s, e);
//				total += v;
//				last_line = v;
//				cnt++;
//			}
//		}
		
		
		while(!pq.isEmpty() || cnt < n-1) {
			Line curr = pq.poll();
			int v = curr.v;
			int s = curr.s;
			int e = curr.e;
			if(find_parent(s) == find_parent(e)) {
				continue;
			}else {
				union(s, e);
				total += v;
				last_line = v;
				cnt++;
			}
		}
		
		System.out.println(total-last_line);
	}

	private static int find_parent(int i) {
		if(parent[i] != i) return parent[i] = find_parent(parent[i]);
		return i;
	}

	private static void union(int s, int e) {
		int ps = find_parent(s);
		int pe = find_parent(e);
		parent[ps] = pe;
	}

}
