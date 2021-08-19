package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Q_1654 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<k;i++) {
			list.add(sc.nextInt());
		}
		long left = 0;
		long right = Long.MAX_VALUE;
		long mid = 0;
		long ans = 0;
		while(left<=right) {
			mid = (left+right)/2;
//			System.out.println("mid : "+mid);
			long temp = 0;
			for (int i = 0; i < list.size(); i++) {
				temp += list.get(i)/mid;
			}
//			System.out.println("temp : "+temp);
			if(temp < n) {
				right = mid-1;
			}else {
				left = mid+1;
				ans = Math.max(ans, mid);
			}
		}
		System.out.println(ans);
	}

}
