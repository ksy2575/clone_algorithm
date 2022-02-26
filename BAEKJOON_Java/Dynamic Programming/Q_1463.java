package baekjoon.dp;

import java.util.Scanner;

public class Q_1463 {
	static int[] memo;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		memo = new int[Math.max(4, n+1)];
		memo[2] = 1;
		memo[3] = 1;
//		System.out.println(dp(n));
		for (int i = 4; i <= n; i++) {
			int minVal = Integer.MAX_VALUE;
			if(i%3 == 0) {
				minVal = Math.min(minVal, memo[i/3]+1);
			}
			if(i%2 == 0) {
				minVal = Math.min(minVal, memo[i/2]+1);
			}
			memo[i] = Math.min(minVal, memo[i-1]+1);
		}
//		System.out.println(dp(n));
		System.out.println(memo[n]);
	}

//	private static int dp(int i) {
//		if(i == 1) return 0;
//		if(memo[i]!=0) return memo[i];
//		
//		int minVal = Integer.MAX_VALUE;
//		if(i%3 == 0) {
//			minVal = Math.min(minVal, dp(i/3))+1;
//		}
//		if(i%2 == 0) {
//			minVal = Math.min(minVal, dp(i/2))+1;
//		}
//		memo[i] = Math.min(dp(i-1)+1, minVal);
//		
//		return memo[i];
//	}

}
