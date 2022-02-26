package baekjoon.BackTracking;

import java.util.Scanner;

public class Q_17070 {
	static int[][] di = {{0, 1}, {0, 1, 1}, {16, 1, 1}};
	static int[][] dj = {{1, 1}, {1, 1, 0}, {16, 1, 0}};
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		dfs(0, 1, 0, n, arr);
		System.out.println(ans);
	}
	private static void dfs(int i, int j, int state, int n, int[][] arr) {
		if(i == n-1 && j == n-1) {
			ans++;
			return;
		}
		for(int k = 0; k < di[state].length; k++) {
			int ni = i+di[state][k];
			int nj = j+dj[state][k];
			if(ni < n && nj < n && arr[ni][nj]!=1) {
				if(k == 1) {
					if(arr[ni-1][nj]==1 || arr[ni][nj-1]==1) {
						continue;
					}
				}
				dfs(ni, nj, k, n, arr);
			}
		}
	}

}
