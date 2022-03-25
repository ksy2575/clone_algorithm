package lv2;

//dfs, brute force
public class Solution_거리두기_확인하기 {
	static int[] di = {1, -1, 0, 0};
	static int[] dj = {0, 0, 1, -1};
	
	public int[] solution(String[][] places) {
		int[] answer = new int[5];
		int i = 0;
		for(String[] place : places) {
			answer[i++] = find(place)?1:0;
		}
		return answer;
	}

	public boolean find(String[] place) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(place[i].charAt(j) == 'P' && !isGood(place, i, j, -1, -1, 0)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isGood(String[] place, int i, int j, int pi, int pj, int cnt) {
		for(int k = 0; k < 4; k++) {
			int ci = i + di[k];
			int cj = j + dj[k];
			if(ci == pi && cj == pj) continue;
			if(ci < 0 || ci >= 5 || cj < 0 || cj >= 5) continue;
			if(cnt == 0 && place[ci].charAt(cj) == 'P') {
				return false;
			}
			if(cnt == 0) {
				if(place[ci].charAt(cj) != 'X' && !isGood(place, ci, cj, i, j, 1)) {
					return false;
				}
			}
			if(cnt == 1 && place[ci].charAt(cj) == 'P') {
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution_거리두기_확인하기 solution = new Solution_거리두기_확인하기();
		System.out.println(solution.solution(new String[][] {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}}));
	}
}
