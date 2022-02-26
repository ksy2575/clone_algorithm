package hash;

import java.util.Arrays;
import java.util.List;

public class Solution_전화번호_목록 {
	public boolean solution(String[] phone_book) {
        List<String> list = Arrays.asList(phone_book);
        list.sort(null);
        for(int i = 0; i < list.size()-1; i++) {
        	if(list.get(i+1).startsWith(list.get(i))) {
        		return false;
        	}
        }
        return true;
    }
	
	public static void main(String[] args) {
		Solution_전화번호_목록 solution = new Solution_전화번호_목록();
		System.out.println(solution.solution(new String[] {"119", "97674223", "1195524421"}));
	}

}
