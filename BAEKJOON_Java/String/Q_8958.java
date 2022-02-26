package baekjoon.String;

import java.util.Scanner;

public class Q_8958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int index=1;index<=T;index++) {
			int ans = 0;
			String s = sc.next();
			int cnt = 1;
			for(char c:s.toCharArray()) {
				if(c=='O') {
					ans+=cnt++;
				}else {
					cnt=1;
				}
			}
			
			System.out.println(ans);
		}
	}

}
