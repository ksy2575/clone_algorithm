package baekjoon.BackTracking;

import java.util.Scanner;

public class Q_1038_1 {
	//모든 수에 대해 탐색하니 시간 초과 -> 실패
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = -1;
		if(n > 1022) {
			System.out.println(-1);
			return;
		}
		num : for (long curr = 0; curr <= 9876543210L; curr++) {
			long temp = curr;
			int pre = -1;
			while(true) {
				if(temp < 10) {
					if(temp > pre) {
						cnt++;
					}
					break;
				}
				
				if(temp%10 <= pre) {
					continue num;
				}else {
					pre = (int) (temp%10);
					temp = temp/10;
				}
				
			}
			if(cnt == n) {
				System.out.println(curr);
				return;
			}
		}
		System.out.println(-1);
	}

}
