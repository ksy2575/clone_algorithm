package baekjoon.Simulation;

import java.util.Scanner;

public class Q_13300 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int ans = 0;
		int[][] arr = new int [2][6];
		for (int i = 0; i < n; i++) {
			int s = sc.nextInt();
			int y = sc.nextInt();
			arr[s][y-1]++;
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				ans += (arr[i][j]/k);
				if(arr[i][j]%k > 0) {
					ans++;
				}
			}
		}
		System.out.println(ans);
		
	}

}
