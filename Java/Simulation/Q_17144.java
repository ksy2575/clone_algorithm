package baekjoon.Simulation;

import java.awt.Point;
import java.util.Arrays;
import java.util.Scanner;

public class Q_17144 {
	static int[][] arr;
	static int r, c;
	static Point pos;
	static int[] di = {1, 0, -1, 0};
	static int[] dj = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		int t = sc.nextInt();
		arr = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int curr = sc.nextInt();
				arr[i][j] = curr;
				
				if(curr == -1 && pos == null) {
					pos = new Point(i, j);
				}
			}
		}
		for (int i = 0; i < t; i++) {
			simulation();

			simulationUp();
			simulationDown();
		}
		System.out.println(sum_total());
	}
	private static void simulation() {
		int[][] next = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(arr[i][j]>0) {//확산 계산
					int pre = arr[i][j];
					for (int k = 0; k < 4; k++) {
						int ni = i+di[k];
						int nj = j+dj[k];
						if(ni >= 0 && ni < r && nj >= 0 && nj < c) {
							if(arr[ni][nj] != -1) {//요기 조심
								int value = arr[i][j]/5;
								next[ni][nj] += value;
								pre -= value;
							}
						}
					}
					next[i][j] += pre;
					
				}
			}
		}
		//카피
		for (int i = 0; i < r; i++) {
			arr[i] = Arrays.copyOf(next[i], c);
		}
		//공기청정기 위치
		arr[pos.x][pos.y] = -1;
		arr[pos.x+1][pos.y] = -1;
	}

	private static void simulationUp() {
		//위
		int i = pos.x;
		int j = pos.y;
		int k = 2;
		while(true) {
			int ni = i+di[k];
			int nj = j+dj[k];
			if(!(ni >= 0 && ni < pos.x+1 && nj >= 0 && nj < c)) {
				k = (k+3)%4;
				ni = i+di[k];
				nj = j+dj[k];
			}
			if(arr[ni][nj] == -1) {
				arr[i][j] = 0;
				break;
			}
			
			if(arr[i][j] != -1) {
				arr[i][j] = arr[ni][nj];
			}
			
			
			i = ni;
			j = nj;
		}
	}
	
	private static void simulationDown() {		
		//아래
		int i = pos.x+1;
		int j = pos.y;
		int k = 0;
		while(true) {
			int ni = i+di[k];
			int nj = j+dj[k];
			if(!(ni >= pos.x+1 && ni < r && nj >= 0 && nj < c)) {
				k = (k+1)%4;
				ni = i+di[k];
				nj = j+dj[k];
			}
			if(arr[ni][nj] == -1) {
				arr[i][j] = 0;
				break;
			}
			
			if(arr[i][j] != -1) {
				arr[i][j] = arr[ni][nj];
			}
			
			
			i = ni;
			j = nj;
		}
	}
	
	private static int sum_total() {
		int retVal = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int curr = arr[i][j];
				retVal += Math.max(0, curr);
			}
		}
		return retVal;
	}

	private static void print(int[][] arr2) {
		System.out.println();
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
