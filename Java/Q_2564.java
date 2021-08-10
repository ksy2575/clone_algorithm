package baekjoon;

import java.util.Scanner;

public class Q_2564 {
	static int[][] arr;
	static int m;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		m = sc.nextInt();
		n = sc.nextInt();
		int cnt = sc.nextInt();
		arr = new int[cnt][2];
		for(int i=0;i<cnt;i++) {
			int pos = sc.nextInt();
			int k = sc.nextInt();
			int[] temp = save(pos, k);
			arr[i][0] = temp[0];
			arr[i][1] = temp[1];
		}
		
		int pos = sc.nextInt();
		int k = sc.nextInt();
		int[] temp = save(pos, k);
		int curri = temp[0];
		int currj = temp[1];
		for (int i = 0; i < arr.length; i++) {
			if(Math.abs(curri-arr[i][0])==n) {
				ans += n;
				ans += Math.min(currj+arr[i][1], 2*m-(currj+arr[i][1]));
			}
			else if(Math.abs(currj-arr[i][1])==m) {
				ans += m;
				ans += Math.min(curri+arr[i][0], 2*m-(curri+arr[i][0]));
			}
			else {
				ans += Math.abs(curri-arr[i][0])+Math.abs(currj-arr[i][1]);
			}
			
		}
		System.out.println(ans);
	}
	
	static int[] save(int pos, int k) {
		switch (pos) {
		case 1:
			return new int[]{0, k};

		case 2:
			return new int[]{n, k};

		case 3:
			return new int[]{k, 0};

		case 4:
			return new int[]{k, m};

		default:
			return new int[]{0, 0};
		}
	}

}
