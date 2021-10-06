package baekjoon.Simulation;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class Q_15685 {
	//드래곤커브
	/*  3
		3 3 0 1
		4 2 1 3
		4 2 2 1
	 */
	static int[] di = {0, -1, 0, 1};//동 북 서 남
	static int[] dj = {1, 0, -1, 0};
	static boolean arr[][] = new boolean[101][101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			dragon(y, x, d, 0, g, new ArrayList<Point>());
		}
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				if(arr[i][j] && arr[i+1][j] && arr[i][j+1] && arr[i+1][j+1]) {
					ans++;
				}
			}
		}
		System.out.println(ans);
		
	}
	private static void dragon(int i, int j, int d, int curr, int g, ArrayList<Point> visited) {
//		print();
//		System.out.println(visited);
		if(curr>g) {
			return;
		}
		if(curr == 0) {
			arr[i][j] = true;
			int ni = i + di[d];
			int nj = j + dj[d];
			arr[ni][nj] = true;
			visited.add(new Point(i, j));
			visited.add(new Point(ni, nj));
			dragon(ni, nj, d, curr+1, g, visited);
		}else {
			int ri = -1;
			int rj = -1;
			int size = visited.size();
			for(int k = 0; k < size; k++) {
				//i, j에 대하여 시계방향 회전, 첫 좌표 기억
				int pi = visited.get(k).x;
				int pj = visited.get(k).y;

				int ni = (pj-j)+i;
				int nj = -(pi-i)+j;
				if(ri == -1) ri = ni;//첫 좌표 기억 - 다음 시작 좌표
				if(rj == -1) rj = nj;
				
				arr[ni][nj] = true;
				visited.add(new Point(ni, nj));
			}
			dragon(ri, rj, d, curr+1, g, visited);
		}
	}
	private static void print() {
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j]) System.out.print(1 + " ");
				else System.out.print(0 + " ");
			}
			System.out.println();
		}
	}

}
