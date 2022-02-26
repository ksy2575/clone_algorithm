package baekjoon.Simulation;

import java.util.Arrays;
import java.util.Scanner;

public class Q_10163 {
	static int[][] arr = new int[1001][1001];
	private static int[] cnts = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		cnts  = new int[n+1];
		for (int i = 1; i <= n; i++) {
			int cj = sc.nextInt();
			int ci = sc.nextInt();
			int k = sc.nextInt();
			int h = sc.nextInt();
			paper(ci, cj, k, h, i);
//			System.out.println(Arrays.toString(cnts));
//			print(arr);
			
		}
		for (int i = 1; i < cnts.length; i++) {
			System.out.println(cnts[i]);
		}
	}
	private static void print(int[][] arr2) {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void paper(int ci, int cj, int k, int h, int index) {
		for (int i = ci; i < ci+h; i++) {
			for (int j = cj; j < cj+k; j++) {
				if(arr[i][j]==0) {
					arr[i][j] = index;
				}else {
					cnts[arr[i][j]]--;
					arr[i][j] = index;
				}
				cnts[index]++;
			}
		}
	}

}
