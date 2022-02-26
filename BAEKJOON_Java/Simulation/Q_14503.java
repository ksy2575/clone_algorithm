package baekjoon.Simulation;

import java.util.Scanner;

public class Q_14503 {
	static int[][] arr;
	static int ci, cj, dir;
	static int[] di = {-1, 0, 1, 0};//북 동 남 서
	static int[] dj = {0, 1, 0, -1};
	static boolean isfinished = false;
	static int n, m, ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][m];
		
		ci = sc.nextInt();
		cj = sc.nextInt();
		dir = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
		simulation();
		System.out.println(ans);
		
	}
	private static void simulation() {
		simu : while(!isfinished) {
			//1
			if(arr[ci][cj] != 2) {
				arr[ci][cj] = 2;
				ans++;
			}
			
			
			//2
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				//a
				int nextDir = (dir+3)%4;
				int ni = ci+di[nextDir];
				int nj = cj+dj[nextDir];
				if(ni >= 0 && ni < n && nj >= 0 && nj < m) {
					if(arr[ni][nj] != 1 && arr[ni][nj] != 2) {
						dir = nextDir;
						ci = ni;
						cj = nj;
						continue simu;
					}
					cnt++;
					dir = nextDir;
					if(cnt == 4) {
						if(arr[ci+di[(dir+2)%4]][cj+dj[(dir+2)%4]] != 1) {
							ci = ci+di[(dir+2)%4];
							cj = cj+dj[(dir+2)%4];
						}
						else {
							isfinished = true;
							break;
						}
					}
				}
			}
		}
	}

}
