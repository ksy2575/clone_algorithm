package baekjoon;

import java.util.Scanner;

public class Q_2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 4 || n == 7) {
			System.out.println(-1);
			return;
		}
		int ans = n/5;
		n %= 5;
		
		switch (n) {
		case 0:
			break;

		case 1:
			ans += 1;
			break;
		case 2:
			ans += 2;
			break;
		case 3:
			ans += 1;
			break;
		case 4:
			ans += 2;
			break;
		default:
			break;
		}
		System.out.println(ans);
	}

}
