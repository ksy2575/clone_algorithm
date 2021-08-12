package baekjoon;

import java.util.Scanner;

public class Q_2578 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[5][5];
		boolean[][] visited = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int curr = 0;
		boolean flag = false;
		for (int i = 1; i <= 25; i++) {
			curr = sc.nextInt();
			check(arr, visited,  curr);
			if(bingo(visited) >= 3 && !flag) {
				System.out.println(i);
				flag = true;
			}
		}
	}
	
	static void check(int[][] arr, boolean[][] visited, int curr) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(arr[i][j] == curr) {
					visited[i][j] = true;
					return;
				}
			}
		}
	}

	static int bingo(boolean[][] visited) {
		int bingo = 0;
		int cnt = 0;
		garo : for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(!visited[i][j]) {
					continue garo;
				}
			}
			bingo++;
		}
		sero : for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 5; i++) {
				if(!visited[i][j]) {
					continue sero;
				}
			}
			bingo++;
		}
		cnt = 0;
		for (int i = 0; i < 5; i++) {
			if(!visited[i][i]) {
				break;
			}
			cnt++;
		}
		if(cnt==5) {
			bingo++;
		}
		cnt = 0;
		for (int i = 0; i < 5; i++) {
			if(!visited[i][4-i]) {
				break;
			}
			cnt++;
		}
		if(cnt==5) {
			bingo++;
		}
		return bingo;
	}
	
	static void print(boolean[][] visited) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
	}

}
