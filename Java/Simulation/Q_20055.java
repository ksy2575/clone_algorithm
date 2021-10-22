package baekjoon.Simulation;

import java.util.Arrays;
import java.util.Scanner;

public class Q_20055 {
	//컨베이어 벨트 위의 로봇
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		cnt = sc.nextInt();
		int[] arr = new int[2*n];
		for (int i = 0; i < 2*n; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(simul(arr, new boolean[n]));
	}

	private static int simul(int[] arr, boolean[] robots) {
		int k = 1;
		while(true) {
			one(arr, robots);
			two(arr, robots);
			three(arr, robots);
			if(cnt <= 0) break;
			k++;
		}
		return k;
	}



	private static void one(int[] arr, boolean[] robots) {
		int n = robots.length;
		for (int i = n-1; i > 0; i--) {
			robots[i] = robots[i-1];
		}
		robots[n-1] = false;
		robots[0] = false;
		int temp = arr[2*n-1];
		for (int i = 2*n-1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
	}

	private static void two(int[] arr, boolean[] robots) {
		int n = robots.length;
		for (int i = n-1; i > 0; i--) {
			if(!robots[i] && robots[i-1] && arr[i] > 0) {
				robots[i] = true;
				robots[i-1] = false;
				arr[i]--;
				if(arr[i] == 0) {
					cnt--;
				}
			}
			
		}
	}
	
	private static void three(int[] arr, boolean[] robots) {
		if(arr[0] > 0) {
			robots[0] = true;
			arr[0]--;
			if(arr[0] == 0) {
				cnt--;
			}
		}
	}
}
