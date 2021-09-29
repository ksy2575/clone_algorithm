package baekjoon.Simulation;

import java.util.Scanner;

public class Q_14499 {
	static int[] di = {0, 0, 0, -1, 1};//0동서북남
	static int[] dj = {0, 1, -1, 0, 0};
	static int[] dice = {0, 0, 0, 0, 0, 0, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int y = sc.nextInt();
		int x = sc.nextInt();
		int cnt = sc.nextInt();
		int[][] arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < cnt; i++) {
			int k = sc.nextInt();
			int ni = y + di[k];
			int nj = x + dj[k];
			if(ni < 0 || ni >= n || nj < 0 || nj >= m) {
				continue;
			}
			
			int temp = dice[6];
			
			if(k == 1) {
				dice[6] = dice[3];
				dice[3] = dice[1];
				dice[1] = dice[4];
				dice[4] = temp;
			}else if(k == 2) {
				dice[6] = dice[4];
				dice[4] = dice[1];
				dice[1] = dice[3];
				dice[3] = temp;
			}else if(k == 3) {
				dice[6] = dice[2];
				dice[2] = dice[1];
				dice[1] = dice[5];
				dice[5] = temp;
			}else {
				dice[6] = dice[5];
				dice[5] = dice[1];
				dice[1] = dice[2];
				dice[2] = temp;
			}
			
			y = ni;
			x = nj;
			int floor = arr[y][x];
			
			if(floor == 0) {
				arr[y][x] = dice[6];
			}else {
				dice[6] = floor;
				arr[y][x] = 0;
			}
			System.out.println(dice[1]);
		}
		
	}

	private static void print(int[][] arr) {
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
