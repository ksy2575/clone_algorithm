package baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_14890 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());;
		int ans = 0;
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][n];
		boolean[] visited;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		outer : for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			int pre = 0;
			for (int j = 0; j < n; j++) {
				if(j == 0) {
					pre = arr[i][j];
					continue;
				}
				int curr = arr[i][j];
				if(Math.abs(curr-pre) > 1) {
					continue outer;
				}else if(curr-pre == 1) {//오르막
					for (int k = 0; k < l; k++) {
						if(j-1-k < 0) continue outer;
						if(arr[i][j-1-k]!=curr-1) continue outer;
						if(visited[j-1-k]) continue outer;
						visited[j-1-k] = true;
					}
				}else if(curr-pre == -1) {//내리막
					for (int k = 0; k < l; k++) {
						if(j+k >= n) continue outer;
						if(arr[i][j+k]!=curr) continue outer;
						if(visited[j+k]) continue outer;
						visited[j+k] = true;
					}
				}
				pre = curr;
			}
			ans++;
		}
		outer : for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			int pre = 0;
			for (int j = 0; j < n; j++) {
				if(j == 0) {
					pre = arr[j][i];
					continue;
				}
				int curr = arr[j][i];
				if(Math.abs(curr-pre) > 1) {
					continue outer;
				}else if(curr-pre == 1) {//오르막
					for (int k = 0; k < l; k++) {
						if(j-1-k < 0) continue outer;
						if(arr[j-1-k][i]!=curr-1) continue outer;
						if(visited[j-1-k]) continue outer;
						visited[j-1-k] = true;
					}
				}else if(curr-pre == -1) {//내리막
					for (int k = 0; k < l; k++) {
						if(j+k >= n) continue outer;
						if(arr[j+k][i]!=curr) continue outer;
						if(visited[j+k]) continue outer;
						visited[j+k] = true;
					}
				}
				pre = curr;
			}
			ans++;
		}
		System.out.println(ans);
	}
}
