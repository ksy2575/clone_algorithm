package baekjoon.Simulation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Number implements Comparable<Number>{
	
	int num;
	int cnt;

	public Number(int n1, int n2) {
		this.num = n1;
		this.cnt = n2;
	}
	
	@Override
	public int compareTo(Number n) {
		if(this.cnt < n.cnt) return -1;
		else if(this.cnt == n.cnt) {
			return this.num-n.num;
		}
		return 1;
	}
	
}

public class Q_17140 {
	static final int MAX = 100;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt()-1;
		int c = sc.nextInt()-1;
		int k = sc.nextInt();
		int[][] arr = new int[MAX][MAX];
		int row = 3;
		int col = 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int t = 0;
		while(t < 100 && arr[r][c] != k) {
//			System.out.println(t);
//			System.out.println(row + " : " + col);
			if(row >= col) {
				int temp = 0;
				for (int i = 0; i < row; i++) {
					HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
					for (int j = 0; j < col; j++) {
						visited.put(arr[i][j], visited.getOrDefault(arr[i][j], 0)+1);
					}
//					System.out.println(visited);
					PriorityQueue<Number> pq = new PriorityQueue<Number>();
					for (Integer curr : visited.keySet()) {
						if(curr == 0) continue;
						pq.add(new Number(curr, visited.get(curr)));
					}
//					System.out.println(pq.size());
					int cnt = 0;
					Queue<Integer> dq = new LinkedList<Integer>();
					while(!pq.isEmpty()) {
						Number curr = pq.poll();
						dq.add(curr.num);
						dq.add(curr.cnt);
					}
					while(cnt < MAX) {
						if(!dq.isEmpty()) {
							int curr = dq.poll();
							arr[i][cnt++] = curr;
							temp = Math.max(temp, cnt);
						}
						else {
							arr[i][cnt++] = 0;
						}
					}
				}
				col = temp;
			}else {
				int temp = 0;
				for (int i = 0; i < col; i++) {
					HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
					for (int j = 0; j < row; j++) {
						visited.put(arr[j][i], visited.getOrDefault(arr[j][i], 0)+1);
					}
					PriorityQueue<Number> pq = new PriorityQueue<Number>();
					for (Integer curr : visited.keySet()) {
						if(curr == 0) continue;
						pq.add(new Number(curr, visited.get(curr)));
					}
//					System.out.println(pq.size());
					int cnt = 0;
					Queue<Integer> dq = new LinkedList<Integer>();
					while(!pq.isEmpty()) {
						Number curr = pq.poll();
						dq.add(curr.num);
						dq.add(curr.cnt);
					}
					while(cnt < MAX) {
						if(!dq.isEmpty()) {
							int curr = dq.poll();
							arr[cnt++][i] = curr;
							temp = Math.max(temp, cnt);
						}
						else {
							arr[cnt++][i] = 0;
						}
					}
				}
				row = temp;
			}
			t++;
//			print(arr);
//			if(t == 10) break;
		}
		
		if(arr[r][c] == k) System.out.println(t);
		else System.out.println(-1);
		
	}

	private static void print(int[][] arr) {
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
