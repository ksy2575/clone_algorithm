package baekjoon;

import java.util.Scanner;
public class Q_16935 {
	static int N=0;
	static int M=0;

	static int[] di={0, 1, 0, -1};
	static int[] dj={1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int cmds = sc.nextInt();
		
		int[][] arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < cmds; i++) {
			int cmd = sc.nextInt();
			arr = rotate(arr, cmd);
		}
		
		print(arr);
		
	}

	static int[][] rotate(int[][] arr, int cmd) {
		int[][] temp = null;
		switch (cmd) {
		case 1:
			temp = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[N-1-i][j] = arr[i][j];
				}
			}
			break;

		case 2:
			temp = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[i][M-1-j] = arr[i][j];
				}
			}
			break;

		case 3:
			temp = new int[M][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[j][N-1-i] = arr[i][j];
				}
			}
			int t = M;
			M = N;
			N = t;
			break;

		case 4:
			temp = new int[M][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[M-1-j][i] = arr[i][j];
				}
			}
			int tt = M;
			M = N;
			N = tt;
			break;

		case 5:
			temp = new int[N][M];
			int n = N/2;
			int m = M/2;
			int dir = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(i/n==0 && j/m==0) {
						dir = 0;
					}else if(i/n==0 && j/m==1) {
						dir = 1;
					}else if(i/n==1 && j/m==1) {
						dir = 2;
					}else if(i/n==1 && j/m==0) {
						dir = 3;
					}
					int ni = i+di[dir]*n;
					int nj = j+dj[dir]*m;
					temp[ni][nj] = arr[i][j];
				}
			}
			break;

		case 6:
			temp = new int[N][M];
			int nn = N/2;
			int mm = M/2;
			int dirr = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(i/nn==0 && j/mm==0) {
						dirr = 1;
					}else if(i/nn==0 && j/mm==1) {
						dirr = 2;
					}else if(i/nn==1 && j/mm==1) {
						dirr = 3;
					}else if(i/nn==1 && j/mm==0) {
						dirr = 0;
					}
					int ni = i+di[dirr]*nn;
					int nj = j+dj[dirr]*mm;
					temp[ni][nj] = arr[i][j];
				}
			}
			break;

		default:
			break;
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
