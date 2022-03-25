package lv2;

import java.util.ArrayList;
import java.util.List;

//simulation, array
public class Solution_행렬_테두리_회전하기 {
	static int[] di = {0, 1, 0, -1};// 우 하 좌 상
	static int[] dj = {1, 0, -1, 0};
	static List<Integer> ansList = new ArrayList<Integer>();
	public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows][columns];
        int cnt = 1;
        for(int i = 0; i < rows; i++) {
        	for(int j = 0; j < columns; j++) {
        		arr[i][j] = cnt++;
        	}
        }
        for(int[] query : queries) {
        	spin(arr, query[0]-1, query[1]-1, query[2]-1, query[3]-1);
        }
        
        return ansList.stream().mapToInt(x->(int)x).toArray();
    }
	
	public void spin(int[][] arr, int si, int sj, int ei, int ej) {
		int ci = si;
		int cj = sj;
		int pre = arr[si][sj];
		int curr = 0;
		int k = 0;
		int min = pre;
		while(true) {
			int ni = ci + di[k];
			int nj = cj + dj[k];
			curr = arr[ni][nj];
			arr[ni][nj] = pre;
			pre = curr;
			min = Math.min(min, pre);
			ci = ni;
			cj = nj;
			if(ci + di[k] < si || ci + di[k] > ei || cj + dj[k] < sj || cj + dj[k] > ej) {
				k = (k+1)%4;
			}
			if(ni == si && nj == sj) break;
		}
		ansList.add(min);
	}

	private void print(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
        	for(int j = 0; j < arr[0].length; j++) {
        		System.out.print(arr[i][j] + "\t");
        	}
        	System.out.println();
        }
		System.out.println();
		
	}

	public static void main(String[] args) {
		Solution_행렬_테두리_회전하기 solution = new Solution_행렬_테두리_회전하기();
		System.out.println(solution.solution(6, 6, new int[][] {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}));
	}
}
