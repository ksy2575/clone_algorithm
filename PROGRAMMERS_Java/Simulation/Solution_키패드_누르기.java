package simulation;

//simulation
public class Solution_키패드_누르기 {
	// 1, 4, 7 - L -> n%3 == 1
	// 3, 6, 9 - R -> n%3 == 0, n!=0 (※0은 11로 계산하기)
	// 2, 5, 8, 0 - 가까운 손가락 -> 나머지
	
	// 거리 계산 = 3씩 뺄 수 있으면 빼고 나머지 1씩 빼기 ※0은 조심 -> 11로 계산하기
	public String solution(int[] numbers, String hand) {
        int l = 10;
        int r = 12;
        StringBuilder sb = new StringBuilder();
        for(int curr : numbers) {
        	if(curr == 0) curr = 11;
        	if(curr%3 == 1) {
        		l = curr;
        		sb.append("L");
        	}else if(curr%3 == 0) {
        		r = curr;
        		sb.append("R");
        	}else {
        		int l_dist = getDistance(l, curr);
        		int r_dist = getDistance(r, curr);
            	if(l_dist < r_dist) {
            		sb.append("L");
            		l = curr;
            	}else if(l_dist > r_dist) {
            		sb.append("R");
            		r = curr;
            	}else {
            		if(hand.equals("left")) {
                		l = curr;
                		sb.append("L");
            		}else {
                		r = curr;
                		sb.append("R");
            		}
            	}
        		
        	}
        }
        
        return sb.toString();
    }

	public int getDistance(int l, int curr) {
		return Math.abs(l-curr)/3 + Math.abs(l-curr)%3;
	}

	public static void main(String[] args) {
		Solution_키패드_누르기 solution = new Solution_키패드_누르기();
		System.out.println(solution.solution(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
		//LRLLLRLLRRL
//		System.out.println(solution.solution(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
//		//LRLLLRLLRRL
//		System.out.println(solution.solution(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
//		//LRLLLRLLRRL
	}
}
