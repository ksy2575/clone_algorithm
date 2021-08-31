package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q_2583 {
	static int[][] arr;
	static int[] di = {0, 0, 1, -1};
	static int[] dj = {1, -1, 0, 0};
	static int m, n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		arr = new int[m][n];
		int ans = 0;
		int k = sc.nextInt();
		for (int idx = 0; idx < k; idx++) {
			int sj = sc.nextInt();
			int si = sc.nextInt();
			int ej = sc.nextInt();
			int ei = sc.nextInt();
			for (int i = si; i < ei; i++) {
				for (int j = sj; j < ej; j++) {
					arr[i][j] = 1;
				}
			}
		}
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j] == 0) {
					l1.add(dfs(i, j, 0));
					ans++;
				}
			}
		}
		Collections.sort(l1);
		System.out.println(ans);
		System.out.println(l1.toString().replace("[", "").replace("]", "").replace(",", ""));
		
	}
	private static int dfs(int i, int j, int cnt) {
		arr[i][j] = 1;
		cnt++;
		for (int k = 0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if(ni >= 0 && ni < m && nj >= 0 && nj < n) {
				if(arr[ni][nj] != 1) {
					cnt += dfs(ni, nj, 0);
				}
			}
		}
		return cnt;
	}
	private static void print() {
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}

}
