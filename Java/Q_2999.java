package baekjoon;

import java.util.Scanner;

public class Q_2999 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = s.length();
		StringBuffer sb = new StringBuffer();
		int i = 0, j = 0;
		for(int index=1;index<=Math.sqrt(n);index++) {
			if(n%index==0 && index<=n/index && i<index) {
				i = index;
				j = n/index;
			}
		}
		// k a k
		// o s i     -> koaski
		for(int ii=0;ii<i;ii++) {
			for(int jj=0;jj<j;jj++) {
				sb.append(s.charAt(jj*i+ii));
			}
		}
		System.out.println(sb.toString());
	}

}
