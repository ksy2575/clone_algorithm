package jungol;

import java.util.Scanner;

public class Q_1681 {
	static int minVal = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		boolean[] visited = new boolean[n];
		visited[0] = true;
		permu(arr, visited, 0, 0, 0);
		if(minVal == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(minVal);
		}
	}

	private static void permu(int[][] arr, boolean[] visited, int curr, int cnt, int cost) {
		
		if(cost > minVal) {
			return;
		}
		if(cnt == arr.length-1) {
			if(arr[curr][0] != 0) {
				int total = cost + arr[curr][0];
				minVal = Math.min(minVal, total);
			}
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(!visited[i]) {
				if(arr[curr][i] != 0) {
					visited[i] = true;
					permu(arr, visited, i, cnt+1, cost+arr[curr][i]);
					visited[i] = false;
				}
			}
		}
	}
}
