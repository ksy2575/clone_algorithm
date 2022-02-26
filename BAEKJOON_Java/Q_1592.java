package baekjoon;

import java.util.Scanner;

public class Q_1592 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), m=sc.nextInt(), k=sc.nextInt(); 
		int[] arr = new int[n];
		arr[0] = 1;
		int curr = 0;
		int cnt = 0;
		while(true) {
			if(arr[curr]>=m) {
				break;
			}
			
			if(arr[curr]%2==1) {
				curr = (curr+k)%n;
			}else {
				curr = (n+curr-k)%n;
			}
			arr[curr] += 1;
			cnt++;
		}
		System.out.println(cnt);
	}

}
