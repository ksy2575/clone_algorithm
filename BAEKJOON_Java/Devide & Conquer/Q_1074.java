package baekjoon;

import java.util.Scanner;

public class Q_1074 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int ans = zzz((int)Math.pow(2, n), r, c);
		System.out.println(ans);
	}

	private static int zzz(int n, int r, int c) {
		if(n == 2) {
			if(r == 0) {
				if(c == 0) {
					return 0;
				}else {
					return 1;
				}
			}else {
				if(c == 0) {
					return 2;
				}else {
					return 3;
				}
			}
		}
		if(r < n/2) {
			if(c < n/2) {
				return zzz(n/2, r, c);
			}else {
				return (n/2) * (n/2) + zzz(n/2, r, c-n/2);
			}
		}else {
			if(c < n/2) {
				return (n/2) * (n/2) * 2 + zzz(n/2, r-n/2, c);
			}else {
				return (n/2) * (n/2) * 3 + zzz(n/2, r-n/2, c-n/2);
			}
		}
	}
}
