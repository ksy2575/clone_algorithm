package baekjoon.DFSnBFS;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_7576 {
	static int N, M;
	static int[][] arr;
	static int[] di = {1, 0, -1, 0};
	static int[] dj = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[N][M];
		Queue<Point> dq = new LinkedList<Point>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int curr = sc.nextInt();
				arr[i][j] = curr;
				if(curr == 1) {
					dq.add(new Point(i, j));
				}
			}
		}
		
		System.out.println(bfs(dq));
	}
	private static int bfs(Queue<Point> dq) {
		
		int day = 1;
		
		while(true) {
			Queue<Point> nq = new LinkedList<Point>();
			
			while(!dq.isEmpty()) {
				Point curr = dq.poll();
				int i = curr.x;
				int j = curr.y;
				for (int k = 0; k < 4; k++) {
					int ni = i + di[k];
					int nj = j + dj[k];
					if(ni >= 0 && ni < N && nj >= 0 && nj < M) {
						if(arr[ni][nj] == 0) {
							arr[ni][nj] = day;
							nq.add(new Point(ni, nj));
						}
					}
//					System.out.println("nq : " + nq);
				}
			}
			if(nq.isEmpty()) {
				break;
			}else {
				dq.addAll(nq);
			}
//			print(arr);
			day++;
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] == 0) return -1;
			}
		}
		return day-1;
		
	}
	private static void print(int[][] arr2) {
		System.out.println();
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
