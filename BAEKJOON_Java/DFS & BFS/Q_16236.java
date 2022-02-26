package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_16236 {
	static int[][] arr;
	static int N = 0;
	static int size = 2;
	static int sizeCnt = 0;
	static int n = 0;
	static int cnt = 0;
	static int ci = 0;
	static int cj = 0;
	static int[] di = {0, 1, 0, -1};
	static int[] dj = {1, 0, -1, 0};
	static boolean flag = false;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int curr = sc.nextInt();
				arr[i][j] = curr;
				if(curr !=0 && curr != 9) {
					n++;
				}
				if(curr == 9) {
					ci = i;
					cj = j;
				}
			}
		}
		System.out.println(simulation());
	}
	
	private static int simulation() {
		int ans = 0;
		while(!flag && cnt != n) {
			ans += bfs();
		}
//		print(arr);
		return ans;
	}

	private static int bfs() {
		ArrayList<int[]> visited = new ArrayList<int[]>();
		visited.add(new int[] {ci, cj});
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {ci, cj, 0});
		int time = Integer.MAX_VALUE;
		ArrayList<int[]> pros = new ArrayList<int[]>();
		while(!q.isEmpty()) {
			int[] currArr = q.poll();
			
			if(currArr[2] > time) {
				break;
			}
			
			//확인
			if(arr[currArr[0]][currArr[1]] != 0 && arr[currArr[0]][currArr[1]] < size) {
				if(currArr[2] < time) {
					time = currArr[2];
				}
				pros.add(new int[] {currArr[0], currArr[1]});
			}
			
			for (int k = 0; k < 4; k++) {
				int ni = currArr[0] + di[k];
				int nj = currArr[1] + dj[k];
				
				if(ni >= 0 && ni < N && nj >= 0 && nj < N) {
					if (!isContain(visited, ni, nj)) {
						if(arr[ni][nj] <= size) {
							//이동 가능
							q.offer(new int[] {ni, nj, currArr[2]+1});
							visited.add(new int[] {ni, nj});
						}
					}
				}
			}
		}
		
		//후보 중 선택
		if(pros.size()!=0) {
			int[] pro = select(pros);
			arr[ci][cj] = 0;
			ci = pro[0];
			cj = pro[1];
			arr[ci][cj] = 9;
			cnt++;
			sizeCnt++;
			if(sizeCnt == size) {
				size = Math.min(7, size+1);
				sizeCnt = 0;
			}
		}else {
			flag = true;
			return 0;
		}
		
		
		
		return time;
	}
	
	private static int[] select(ArrayList<int[]> pros) {
		int[] retArr = new int[] {N, N};
		for(int[] tempArr : pros) {
			if(tempArr[0] < retArr[0]) {
				retArr = tempArr;
			}else if(tempArr[0] == retArr[0]) {
				if(tempArr[1] < retArr[1]) {
					retArr = tempArr;
				}
			}
		}
		return retArr;
	}
	
	private static boolean isContain(ArrayList<int[]> visited, int ni, int nj) {
		for(int[] tempArr : visited) {
			if(tempArr[0] == ni && tempArr[1] == nj) {
				return true;
			}
		}
		return false;
	}
	
	private static void print(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
