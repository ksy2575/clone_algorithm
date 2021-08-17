package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Q_17135 {
	static ArrayList<ArrayList<Integer>> combiList = new ArrayList<ArrayList<Integer>>();
	static ArrayList<int[]> archerList = new ArrayList<int[]>();
	static int n = 0;
	static int m = 0;
	static int ans = 0;
	static int d = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();
		ArrayList<int[]> enemyList = new ArrayList<int[]>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(sc.nextInt()==1) {
					enemyList.add(new int[] {i, j});
				}
			}
		}
		
		combi(0, 0, new ArrayList<Integer>());
		for(int i = 0; i < combiList.size(); i++) {
			ArrayList<int[]> tempList = new ArrayList<int[]>();
			for (int j = 0; j < enemyList.size(); j++) {
				tempList.add(new int[] {enemyList.get(j)[0], enemyList.get(j)[1]});
			}
			simulation(combiList.get(i), new ArrayList<int[]>(tempList));
		}
		System.out.println(ans);
		
	}

	private static void simulation(ArrayList<Integer> pos, ArrayList<int[]> enemyList) {
		int hit_cnt = 0;
		for(int j = 0;j < pos.size();j++) {
			archerList.add(new int[] {n, pos.get(j)});
		}
		while(enemyList.size()>0) {
			int[] hitArr = new int[archerList.size()];
			for (int i = 0; i < hitArr.length; i++) {
				hitArr[i] = -1;
			}
			for (int i = 0; i < archerList.size(); i++) {
				int ai = archerList.get(i)[0];
				int aj = archerList.get(i)[1];
				int min_dist = Integer.MAX_VALUE;
				for (int j = 0; j < enemyList.size(); j++) {
					int ei = enemyList.get(j)[0];
					int ej = enemyList.get(j)[1];
					int dist = Math.abs(ei-ai) + Math.abs(ej-aj);
					if(dist <= d) {
						if(dist < min_dist) {
							min_dist = dist;
							hitArr[i] = j;
						}else if(dist == min_dist) {
							if(enemyList.get(hitArr[i])[1]>enemyList.get(j)[1]) {
								hitArr[i] = j;
							}
						}
					}
				}
				
			}
			for(int hitIndex:hitArr) {
				if(hitIndex!=-1) {
					if(enemyList.get(hitIndex) != null) {
						enemyList.set(hitIndex, null);
						hit_cnt++;
					}
				}
			}
			
			for (int i = 0; i < enemyList.size(); i++) {
				if(enemyList.get(i) != null && enemyList.get(i)[0]!=n-1) {
					enemyList.get(i)[0]++;
				}else {
					enemyList.set(i, null);
				}
			}
			while(true) {
				if(!enemyList.remove(null)) {
					break;
				}
			}
		}
		ans = Math.max(ans, hit_cnt);
		archerList.clear();
	}

	private static void combi(int i, int k, ArrayList<Integer> list) {
		if(k == 3) {
			combiList.add(new ArrayList<Integer>(list));
			return;
		}
		if(i >= m) {
			return;
		}
		for (int j = i; j < m; j++) {
			list.add(j);
			combi(j+1, k+1, list);
			list.remove(list.size()-1);
		}
	}

}
