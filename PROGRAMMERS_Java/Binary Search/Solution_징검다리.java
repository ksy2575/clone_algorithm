package binary_search;

import java.util.Arrays;

public class Solution_징검다리 {
	
	public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        int left = 0;
        int right = distance;
        int[] array = Arrays.copyOf(rocks, rocks.length+1);
        array[array.length-1] = distance;
        System.out.println(Arrays.toString(array));
        while(left <= right) {
        	int mid = (left + right)/2;// 이 최소 거리 만들 수 있니?
        	System.out.println("mid : " + mid);
        	int temp = 0;// 이전 돌 위치
        	int cnt = 0;
        	for(int curr : array) {
        		if(curr - temp >= mid) {
        			System.out.println("굳");
        			temp = curr;
        			continue;
        		}else {
        			System.out.println(curr - temp + " 더 부수자");
        			cnt++;// 돌 부수기
        		}
        	}
        	if(cnt <= n) {
        		System.out.println(mid + " 가능!");
        		left = mid + 1;
        		answer = mid;
        	}else {
        		System.out.println(mid + " 불가능...");
        		right = mid - 1;
        	}
        	
        }
        
        
        return answer;
    }
	
	public static void main(String[] args) {
		Solution_징검다리 solution = new Solution_징검다리();
//		System.out.println(solution.solution(6, new int[] {7, 10}));
//		System.out.println(solution.solution(10, new int[] {1, 2, 3, 4, 5}));
//		System.out.println(solution.solution(10, new int[] {6, 8, 10}));
//		System.out.println(solution.solution(3, new int[] {1, 1, 1}));
		System.out.println(solution.solution(25, new int[] {2, 14, 11, 21, 17}, 2));
	}

}
