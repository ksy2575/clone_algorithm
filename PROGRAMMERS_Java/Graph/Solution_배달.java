package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

//Graph
public class Solution_배달 {
	static class Node implements Comparable<Node>{
		int i;
		int v;
		
		public Node(int i, int v) {
			this.i = i;
			this.v = v;
		}

		@Override
		public int compareTo(Node n) {
			return this.v - n.v;
		}
		
	}
	public int solution(int N, int[][] road, int K) {
        int[][] arr = getArray(N, road);
        findMin(N, arr);
        return getCnt(N, arr, K)+1;
    }
	private int getCnt(int n, int[][] arr, int k) {
		int cnt = 0;
		for(int i = 2; i <= n; i++) {
			if(arr[1][i] <= k) cnt++;
		}
		return cnt;
	}
	private void findMin(int n, int[][] arr) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for(int i = 2; i <= n; i++) {
			pq.add(new Node(i, arr[1][i]));
		}
		int cnt = 0;
		boolean[] visited = new boolean[n+1];
		while(cnt < n-1) {
			Node curr = pq.poll();
			int i = curr.i;
			if(visited[i]) continue;
			for(int j = 2; j <= n; j++) {
				if(i == j) continue;
				if(arr[1][j] > arr[1][i] + arr[i][j]) {
					arr[1][j] = arr[1][i] + arr[i][j];
					pq.add(new Node(j, arr[1][j]));
				}
			}
			cnt++;
			visited[i] = true;
		}
	}
	private int[][] getArray(int n, int[][] road) {
		int[][] arr = new int[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			Arrays.fill(arr[i], Integer.MAX_VALUE/10);
		}
		for(int[] r : road) {
			arr[r[0]][r[1]] = Math.min(arr[r[0]][r[1]], r[2]);
			arr[r[1]][r[0]] = Math.min(arr[r[1]][r[0]], r[2]);
		}
		return arr;
	}
	private void print(int n, int[][] arr) {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				System.out.print("\t" + arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Solution_배달 solution = new Solution_배달();
		System.out.println(solution.solution(5, new int[][] {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}, 3));
//		System.out.println(solution.solution(6, new int[][] {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}, 4));
	}

}
