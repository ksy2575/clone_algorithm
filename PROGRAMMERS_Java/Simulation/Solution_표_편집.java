package simulation;

import java.util.Arrays;
import java.util.Stack;

// Simulation
// 커맨드 해석 > for문
// 연결리스트, Stack으로 관리
public class Solution_표_편집 {
	static class Table{
		Stack<Integer> stack = new Stack<Integer>();
		Integer[][] nodes;
		
		public void setNodes(int n) {
			nodes = new Integer[n][2];
			for(int i = 0; i < n; i++) {
				nodes[i] = new Integer[] {i-1, i+1};
			}
			nodes[0][0] = null;
			nodes[n-1][1] = null;
		}

		public int remove(int k) {
			stack.add(k);
			if(nodes[k][0] != null) nodes[nodes[k][0]][1] = nodes[k][1];
			if(nodes[k][1] != null) nodes[nodes[k][1]][0] = nodes[k][0];
			k = getDown(k, 1);
			return k;
		}

		public int getPreNumber() {
			return stack.peek();
		}

		public void undo() {
			int k = stack.pop();
			if(nodes[k][0] != null) nodes[nodes[k][0]][1] = k;
			if(nodes[k][1] != null) nodes[nodes[k][1]][0] = k;
		}

		public Stack<Integer> getStack() {
			return stack;
		}
		
		private int getUpper(int k, int u) {
			while(u > 0) {
				k = nodes[k][0];
				u--;
			}
			return k;
		}

		private int getDown(int k, int d) {
			if(nodes[k][1] == null) return nodes[k][0];
			while(d > 0) {
				k = nodes[k][1];
				d--;
			}
			return k;
		}
	}
	static class Commander{
		int k;
		Table table;
		Commander(int n, int k){
			this.table = new Table();
			this.table.setNodes(n);
			this.k = k;
		}
		
		public void start(String[] cmd) {
			for(String s : cmd) {
				switch (s.charAt(0)) {
				case 'D':
					int d = Integer.parseInt(s.split(" ")[1]);
					k = table.getDown(k, d);
					break;
				case 'U':
					int u = Integer.parseInt(s.split(" ")[1]);
					k = table.getUpper(k, u);
					break;
				case 'C':
					k = this.table.remove(k);
					break;
				case 'Z':
					this.table.undo();
					break;
				default:
					break;
				}
			}
		}

		public String getAnswer(int n) {
			Boolean[] visited = new Boolean[n];
			Arrays.fill(visited, true);
			StringBuilder sb = new StringBuilder();
			Stack<Integer> stack = table.getStack();
			while(!stack.isEmpty()) {
				visited[stack.pop()] = false;
			}
			for(Boolean b : visited) {
				sb.append(b?'O':'X');
			}
			return sb.toString();
		}
	}
	public String solution(int n, int k, String[] cmd) {
        Commander commander = new Commander(n, k);
        commander.start(cmd);
        return commander.getAnswer(n);
    }
	
	public static void main(String[] args) {
		Solution_표_편집 solution = new Solution_표_편집();
		System.out.println(solution.solution(8, 2, new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}));

//		System.out.println(solution.solution(8, 2, new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}));
	}

}
