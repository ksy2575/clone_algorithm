package dfs_bfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Solution_여행경로 {
	
	static boolean flag = false;
	static Stack<String> line = new Stack<String>();
	static String[] answer;
	public String[] solution(String[][] tickets) {
        // dfs - 모든 노드를 정렬해서 앞에서부터 dfs하여 답이 나오자마자 반환
        HashSet<String> citySet = new HashSet<String>();
        for(String[] ticket : tickets) {
        	citySet.add(ticket[0]);
        	citySet.add(ticket[1]);
        }
        String[] cities = new String[] {};
        cities = citySet.toArray(cities);
        Arrays.sort(cities);
        HashMap<String, Integer> indexes = new HashMap<String, Integer>();
        for(int i = 0; i < cities.length; i++) {
        	indexes.put(cities[i], i);
        }
        
        int[][] arr = new int[cities.length][cities.length];
        
        for(String[] ticket : tickets) {
        	arr[indexes.get(ticket[0])][indexes.get(ticket[1])]++;
        }
//        print(arr);
		line.add("ICN");
        dfs(arr, cities, indexes, "ICN", tickets.length);
        return answer;
    }

	private void dfs(int[][] arr, String[] cities, HashMap<String, Integer> indexes, String curr, int n) {
		if(flag) return;
		if(line.size() == n+1) {
//			System.out.println(line);
			answer = line.toArray(new String[line.size()]);
			flag = true;
			return;
		}
		for(int i = 0; i < arr.length; i++) {
			if(arr[indexes.get(curr)][i] > 0) {
				arr[indexes.get(curr)][i]--;
				line.add(cities[i]);
				dfs(arr, cities, indexes, cities[i], n);
				line.pop();
				arr[indexes.get(curr)][i]++;
			}
		}
		
	}

	private void print(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution_여행경로 solution = new Solution_여행경로();
//		System.out.println(solution.solution(new String[][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})); // {"ICN", "JFK", "HND", "IAD"}
		System.out.println(solution.solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})); // {"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}
	}
}
