package baekjoon.Simulation;

import java.util.Scanner;

public class Q_10157 {

	public static void main(String[] args) {
		int[] di = {0, 1, 0, -1};
		int[] dj = {1, 0, -1, 0};
		int dir = 0;
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();
		int k = sc.nextInt();
		
		int l = 0;
		int r = R;
		int t = 0;
		int b = C;
		
		int i = 0;
		int j = 0;
		int cnt = 1;
		
		if(R*C < k) {
			System.out.println(0);
			return;
		}
		while(true) {
			if(cnt == k){
				System.out.println((i+1) + " " + (j+1));
				return;
			}
			int dirCnt = 0;
			int ni = 0;
			int nj = 0;
			while(true) {
				if(dirCnt==4) {
					System.out.println(0);
					return;
				}
				ni = i + di[dir];
				nj = j + dj[dir];
				if(ni < t || ni >= b || nj < l || nj >= r) {
					dir = (dir + 1)%4;
					if(dir == 1) {
						t++;
					}else if(dir == 2) {
						r--;
					}else if(dir == 3) {
						b--;
					}else if(dir == 0) {
						l++;
					}
					dirCnt++;
					continue;
				}
				break;
			}
			i = ni;
			j = nj;
			cnt++;
		}
	}

}
