package baekjoon.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Q_1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt()-1;
		LinkedList<Integer> list = new LinkedList<Integer>();
		ArrayList<Integer> ansList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		int curr = 0;
		
		while(!list.isEmpty()) {
			curr = (curr+k)%n;
			ansList.add(list.get(curr));
			list.remove(curr);
			n--;
		}
		String s = ansList.toString();
		System.out.println(s.replace("[", "<").replace("]", ">"));
	}

}
