package baekjoon.BackTracking;

import java.util.Scanner;

public class Q_1038_2 {
	//dfs를 돌며 유효한 자식노드만 순회 -> 성공
	static int cnt = 0;
	static int n = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		if(n > 1022) {
			System.out.println(-1);
			return;
		}
		if(n == 0) {
			System.out.println(0);
			return;
		}
		for (int i = 1; i <= 10; i++) {
			if(cnt < n) {
				dfs(10, 0, i, "");
			}
		}
	}

	private static void dfs(int currMax, int k, int len, String s) {
		if(cnt < n) {
			if(k == len) {
				cnt++;
				if(cnt==n) {
					System.out.println(s);
				}
				return;
			}
			for (int i = 0; i < currMax; i++) {
				if(cnt >= n) {
					return;
				}
				if(k==0 && i==0) {
					continue;
				}
				dfs(i, k+1, len, s+i);
			}
		}
	}
}
