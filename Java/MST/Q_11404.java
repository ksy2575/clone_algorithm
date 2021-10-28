package baekjoon.mst;

import java.util.Scanner;

public class Q_11404 {
	static final int INF = Integer.MAX_VALUE/2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n+1][n+1];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = INF;
			}
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr[a][b] = Math.min(arr[a][b], c);
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if(i==k) {
					continue;
				}
				for (int j = 1; j <= n; j++) {
					if(i==j || k==j) {
						continue;
					}
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		print(arr);
	}
	private static void print(int[][] arr) {
		for (int i = 1; i < arr.length; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 1; j < arr.length; j++) {
				if(arr[i][j] == INF) {
					sb.append(0 + " ");
				}
				else{
					sb.append(arr[i][j] + " ");
				}
			}
			System.out.println(sb.toString().trim());
		}
	}

}
