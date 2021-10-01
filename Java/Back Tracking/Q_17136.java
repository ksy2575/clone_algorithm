package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q_17136 {
	static boolean[][] arr = new boolean[10][10];
	static int[] papers = {0, 0, 0, 0, 0, 0};
	static int total = 0;
	static int retVal = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				int curr = sc.nextInt();
				arr[i][j] = 1 == curr;
				total += curr;
			}
		}
		dfs(0, 0, 0, 0);
		if(retVal == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(retVal);
		}
	}
	
	private static void dfs(int si, int sj, int cnt, int value) {
		if(cnt > retVal) {
			return;
		}
		if(value == total) {
			retVal = Math.min(retVal, cnt);
			return;
		}
		for (int i = si; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(i == si && j < sj) continue;
				if(arr[i][j]) {
					int k = 5;
					for (; k > 0; k--) {
						if(isPossible(i, j, k)) break;
					}
					for (; k > 0 ; k--) {
						if(papers[k] < 5) {
							cover(i, j, k);
							papers[k]++;
							dfs(i, j+k, cnt+1, value+k*k);
							uncover(i, j, k);
							papers[k]--;
						}
					}
					return;
				}
			}
		}
	}

	private static void cover(int i, int j, int k) {
		for (int ii = 0; ii < k; ii++) {
			for (int jj = 0; jj < k; jj++) {
				int ni = i+ii;
				int nj = j+jj;
				arr[ni][nj] = false;
			}
		}
	}
	private static void uncover(int i, int j, int k) {
		for (int ii = 0; ii < k; ii++) {
			for (int jj = 0; jj < k; jj++) {
				int ni = i+ii;
				int nj = j+jj;
				arr[ni][nj] = true;
			}
		}
	}

	private static boolean isPossible(int i, int j, int k) {
		for (int ii = k-1; ii >= 0; ii--) {
			for (int jj = k-1; jj >= 0; jj--) {
				int ni = i+ii;
				int nj = j+jj;
				if(ni >= 10 || nj >= 10 || !arr[ni][nj]) {
					return false;
				}
			}
		}
		return true;
	}

	private static void print() {
		System.out.println();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(arr[i][j]) {
					System.out.print(1 + " ");
				}else {
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

}
