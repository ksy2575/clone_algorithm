package baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Q_14501 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		int[] memo = new int[n+1];
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
			int p = sc.nextInt();
			arr[i][0] = t;
			arr[i][1] = p;
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = arr[i][0]; i+j < n+1; j++) {
				memo[i+j] = Math.max(arr[i][1]+memo[i], memo[i+j]);
			}
		}
		System.out.println(memo[n]);
	}

}
