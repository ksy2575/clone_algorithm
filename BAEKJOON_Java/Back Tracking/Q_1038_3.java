package baekjoon.BackTracking;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_1038_3 {
	//Queue를 통해 다음 후보를 효과적으로 생성 -> 성공
	static int cnt = 0;
	static int n = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Queue<Long> q = new LinkedList<Long>();
		for (int i = 0; i < 10; i++) {
			q.offer((long) i);
		}
		int cnt = 0;
		Long ans = 0l;
		while(cnt <= n) {
			if(q.size() == 0) {
				ans = -1l;
				break;
			}
			Long curr = q.poll();
			for (int i = 0; i < curr%10; i++) {
				q.offer(curr*10 + i);
			}
			cnt++;
			ans = curr;
		}
		System.out.println(ans);
	}
}
