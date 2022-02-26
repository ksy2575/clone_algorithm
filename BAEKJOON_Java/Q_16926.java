package baekjoon;

import java.util.Scanner;
public class Q_16926 {
	static int N=0;
	static int M=0;
	static int r=0;

	static int[] di={0, 1, 0, -1};
	static int[] dj={1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		r = sc.nextInt();
		
		int[][] arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < r; i++) {
			int[][] temp = new int[N][M];
			arr = rotate(arr, temp, 0);
		}
		
		print(arr);
		
	}

	static int[][] rotate(int[][] arr, int[][] temp, int k) {
		int i = k;
		int j = k;
		int cnt = 0;
		int dir = 0;
		int n = N-k;
		int m = M-k;//범위
		int max = ((n-i)*(m-j))-((n-i)-2)*((m-j)-2);
		while(cnt<max) {
			int ni =i+di[dir];
			int nj =j+dj[dir];
			if(!(ni<n && ni>=k && nj<m && nj>=k)) {
				dir = (dir+1)%4;
				ni =i+di[dir];
				nj =j+dj[dir];
			}
			temp[i][j] = arr[ni][nj];
			i = ni;
			j = nj;
			cnt++;
		}
		if(Math.min(n-k, m-k)>=4) {
			temp = rotate(arr, temp, k+1);
		}
		
		return temp;
	}

	static void print(int[][] temp) {
		for (int i = 0; i < temp.length; i++) {
			StringBuffer s = new StringBuffer();
			for (int j = 0; j < temp[0].length; j++) {
				s.append(temp[i][j] + " ");
			}
			System.out.println(s.toString().trim());
		}
	}

}
