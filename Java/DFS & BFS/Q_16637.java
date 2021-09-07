package baekjoon;

import java.util.Scanner;

public class Q_16637 {
	
	static char[] arr;
	static long ans = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = sc.next().toCharArray();
		
		if(n == 1) {
			System.out.println(arr[0]);
			return;
		}
		for (int i = 1; i <= n/2; i++) {
			combi(0, 0, i, n/2, 0, -1);//i개의 연산 선택
		}
		System.out.println(ans);
	}

	private static void combi(int i, int cnt, int max, int n, long left, int pre) {
		if(cnt==max) {
			//나머지 계산
			long ret = func2(left, pre, n);
			ans = Math.max(ans, ret);
			return;
		}
		if(i > n) {
			return;
		}
		for (int k = i; k < n; k++) {
			long curr = func(2*k+1, left, pre);//계산해서 넣기
			
			combi(k+2, cnt+1, max, n, curr, k);
		}
	}

	private static long func(int i, long left, int pre) {
		if(pre == -1) {
			left = Character.getNumericValue(arr[0]);
		}
		while(2*(++pre)+1<i-2) {
			char curr = arr[2*pre+1];
			switch (curr) {
			case '+':
				left += Character.getNumericValue(arr[2*pre+2]);
				break;

			case '-':
				left -= Character.getNumericValue(arr[2*pre+2]);
				break;

			case '*':
				left *= Character.getNumericValue(arr[2*pre+2]);
				break;

			default:
				break;
			}
		}
		
		char cmd = arr[i];
		int right = 0;
		switch (cmd) {
		case '+':
			right = Character.getNumericValue(arr[i-1]) + Character.getNumericValue(arr[i+1]);
			break;

		case '-':
			right = Character.getNumericValue(arr[i-1]) - Character.getNumericValue(arr[i+1]);
			break;

		case '*':
			right = Character.getNumericValue(arr[i-1]) * Character.getNumericValue(arr[i+1]);
			break;

		default:
			break;
		}
		if(i==1) {
			return right;
		}
		char mid = arr[i-2];
		switch (mid) {
		case '+':
			left += right;
			break;

		case '-':
			left -= right;
			break;

		case '*':
			left *= right;
			break;

		default:
			break;
		}
		return left;
	}

	private static long func2(long left, int pre, int n) {
		if(pre != -1) {
			while(++pre<n) {
				char curr = arr[2*pre+1];
				switch (curr) {
				case '+':
					left += Character.getNumericValue(arr[2*pre+2]);
					break;

				case '-':
					left -= Character.getNumericValue(arr[2*pre+2]);
					break;

				case '*':
					left *= Character.getNumericValue(arr[2*pre+2]);
					break;

				default:
					break;
				}
			}
		}
		return left;
	}
}
