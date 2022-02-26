package baekjoon.dp;

import java.util.Scanner;

public class Q_9205 {
	
	static int INF = Integer.MAX_VALUE/2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int index=1;index<=T;index++) {
			int n = sc.nextInt();
			int[][] arr = new int[n+3][n+3];
			int[][] nodes = new int[n+3][2];
			
			for (int i = 1; i < nodes.length; i++) {
				nodes[i][0] = sc.nextInt();
				nodes[i][1] = sc.nextInt();
			}
			
			
			for (int i = 1; i < arr.length; i++) {
				for (int j = 1; j < arr.length; j++) {
					arr[i][j] = INF;
					int curr = Math.abs(nodes[i][0]-nodes[j][0])+Math.abs(nodes[i][1]-nodes[j][1]);
					if(curr > 1000) continue;
					arr[i][j] = curr;
				}
			}
			for (int k = 1; k <= n+2; k++) {
				for (int i = 1; i <= n+2; i++) {
					for (int j = 1; j <= n+2; j++) {
						if(i != k && i != j && j != k) {
//							System.out.println(k + ", " + i + ", " + j);
							arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
						}
					}
				}
			}
//			print(arr);
			if(arr[1][n+2] != INF) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			
		}
		
	}
	
	private static void print(int[][] arr) {
		for (int i = 1; i < arr.length; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 1; j < arr.length; j++) {
				if(arr[i][j] == -1) {
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
