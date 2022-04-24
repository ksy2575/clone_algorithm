package simulation;

// Simulation, DFS
public class Solution_조이스틱 {
	public int solution(String name) {
        int[] counts = getCountArray(name);
        int cnt = getCnt(counts);
        int v = counts[0];
		counts[0] = 0;
		cnt += v!=0?1:0;
        return dfs(counts, cnt, 0, v);
    }
	private int dfs(int[] counts, int cnt, int i, int total) {
		if(cnt == counts.length) {
			return total;
		}
		int l = i-1;
		int r = i+1;
		int val = 1;
		int temp = 0;
		while(true) {
			if(r >= counts.length) r = 0;
			if(counts[r] != 0) {
				int v = counts[r];
				counts[r] = 0;
				temp = dfs(counts, cnt+1, r, total + val + v);
				counts[r] = v;
				break;
			}
			r++;val++;
		}
		val = 1;
		while(true) {
			if(l < 0) l += counts.length;
			if(counts[l] != 0) {
				int v = counts[l];
				counts[l] = 0;
				temp = Math.min(temp, dfs(counts, cnt+1, l, total + val + v));
				counts[l] = v;
				break;
			}
			l--;val++;
		}
		return temp;
	}
	private int getCnt(int[] counts) {
		int temp = 0;
		for(int i = 0; i < counts.length; i++) {
			if(counts[i] == 0) temp++;
		}
		return temp;
	}
	private int[] getCountArray(String name) {
		int[] arr = new int[name.length()];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
		}
		return arr;
	}
	public static void main(String[] args) {
		Solution_조이스틱 solution = new Solution_조이스틱();
		System.out.println(solution.solution("BBBBAAAABA"));//B B B B A A A A B A
	}
}
