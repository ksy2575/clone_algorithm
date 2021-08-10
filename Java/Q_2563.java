package baekjoon;

import java.util.Scanner;

public class Q_2563 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		int[][] arr = new int[100][100];
		for(int index=1;index<=n;index++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int i = y; i < y+10; i++) {
				for (int j = x; j < x+10; j++) {
					if(arr[i][j] != 1) {
						arr[i][j] = 1;
						ans++;
					}
				}
			}
		}
		System.out.println(ans);
	}

}
