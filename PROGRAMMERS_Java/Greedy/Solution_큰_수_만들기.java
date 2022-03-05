package gready;

public class Solution_큰_수_만들기 {
	public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        // 4177252841 4
        for(int i = 0; i < number.length()-k; i++) {
//            System.out.println("i : " + i);
        	int max = 0;
//            System.out.println("범위 : " + index + " ~ " + (number.length()-k+i));
        	for(int j = index; j < k+i+1; j++) {
        		if(max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    index = j+1;
                }
        	}
        	sb.append(max);
//            System.out.println("sb : " + sb);
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		Solution_큰_수_만들기 solution = new Solution_큰_수_만들기();
		System.out.println(solution.solution("4177252841", 4));
	}

}
