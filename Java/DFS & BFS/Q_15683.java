package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q_15683 {
	static char[][] arr = null;
	private static int n;
	private static int m;
	static int[] di = {0, 1, 0, -1};
	static int[] dj = {1, 0, -1, 0};
	static int[][] cctv = {{}, {0}, {0, 2}, {0, 1}, {0, 1, 2}, {0, 1, 2, 3}};
	private static boolean flag = false;
	private static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		int N = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = bf.readLine().replaceAll(" ", "").toCharArray();
			for (int j = 0; j < m; j++) {
				if(arr[i][j]!='0' && arr[i][j]!='6') {
					N++;
				}
			}
		}
		func(-1, -1, 0, N);
		System.out.println(ans);
	}
	
	private static void func(int y, int x, int cnt, int N) {
		if(cnt==N) {
//			print();
			ans  = Math.min(ans, zeroCnt());
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(isPre(i, j, y, x)) {
					continue;
				}
				if(arr[i][j]!='0' && arr[i][j]!='6' && arr[i][j]!='#') {
					int curr = Character.getNumericValue(arr[i][j]);
//					System.out.println("curr : " + curr);
					int[] currDir = Arrays.copyOf(cctv[curr], cctv[curr].length);
					int range = 0;
					if(curr == 1) range = 4;
					else if(curr == 2) range = 2;
					else if(curr == 3) range = 4;
					else if(curr == 4) range = 4;
					else if(curr == 5) range = 1;
					
					for (int k = 0; k < range; k++) {
						HashSet<int[]> set = new HashSet<int[]>();
						for (int kk = 0; kk < currDir.length; kk++) {
							int ci = di[(currDir[kk]+k)%4];
							int cj = dj[(currDir[kk]+k)%4];
							set = look(i, j, ci, cj, set);//여기 조심
//							printset(set);
						}
						func(i, j, cnt+1, N);
						flag = false;
						//set 원상복구
						redoset(set);
					}
				}
			}
		}
	}
	
	private static void redoset(HashSet<int[]> set) {
		for(Object currPos : set.toArray()) {
			arr[((int[])currPos)[0]][((int[])currPos)[1]] = '0';
		}
	}

	private static HashSet<int[]> look(int i, int j, int ci, int cj, HashSet<int[]> set) {
		int ni = i;
		int nj = j;
		while(true) {
			ni += ci;
			nj += cj;
			if(ni < 0 || ni >= n || nj < 0 || nj >= m) {
				break;
			}else if(arr[ni][nj] == '6') {
				break;
			}
			if(arr[ni][nj] == '0') {
				set.add(new int[] {ni, nj});
				arr[ni][nj] = '#';
			}
		}
		return set;
	}

	private static boolean isPre(int i, int j, int y, int x) {
		if(i<y) {
			return true;
		}else if(i==y) {
			if(j<=x) {
				return true;
			}
		}
		return false;
	}

	private static int zeroCnt() {
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j] == '0') temp++;
			}
		}
		return temp;
	}

	static void print() {
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
