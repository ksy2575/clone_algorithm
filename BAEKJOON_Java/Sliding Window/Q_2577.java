package baekjoon.SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//회전 초밥(고)
public class Q_2577 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		//윈도우
		int ans = 0;
		int[] visited = new int[d+1];
		int l = 0;
		int r = k-1;
		for (int i = 0; i < k; i++) {
			if(visited[arr[i]] == 0) {
				ans++;
			}
			visited[arr[i]]++;
		}
		if(visited[c] == 0) {
			ans++;
		}
		visited[c]++;
		
		int score = ans;
		
		while(l < n-1) {
			int pre = arr[l%n];
			int next = arr[(r+1)%n];
			//빼기
			visited[pre]--;
			if(visited[pre] == 0) {
				score--;
			}
			
			//더하기
			if(visited[next] == 0) {
				visited[next] = 1;
				score++;
			}else {
				visited[next]++;
			}
			ans = Math.max(ans, score);
			l++; r++;
		}
		System.out.println(ans);
	}
}
