package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_베스트앨범 {
	static class Genre implements Comparable<Genre>{
		String name;
		int played;
		PriorityQueue<Music> musicQueue;
		
		public Genre(String name) {
			this.name = name;
			System.out.println(name);
			musicQueue = new PriorityQueue<Music>();
		}
		
		public void addMusic(int index, int played) {
			this.played+= played;
			musicQueue.add(new Music(index, played));
		}
		@Override
		public int compareTo(Genre g) {
			return -(this.played-g.played);//많이 재생된 것이 앞으로 가도록
		}
		@Override
		public String toString() {
			return name + "-" + played + ":" + musicQueue;
		}
	}
	static class Music implements Comparable<Music>{
		int index;
		int played;
		
		public Music(int index, int played) {
			this.index = index;
			this.played = played;
		}
		
		@Override
		public int compareTo(Music m) {
			return -(this.played-m.played);//많이 재생된 것이 앞으로 가도록
		}

		@Override
		public String toString() {
			return "(" + index + ", " + played + ")";
		}
		
	}
	public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Genre> genreMap = new HashMap<String, Genre>();
        for(int i=0;i<genres.length;i++) {
        	if(genreMap.get(genres[i])==null) {
        		genreMap.put(genres[i], new Genre(genres[i]));
        	}
        	genreMap.get(genres[i]).addMusic(i, plays[i]);
        }
        PriorityQueue<Genre> genreQueue = new PriorityQueue<Genre>();
        genreQueue.addAll(genreMap.values());
        List<Integer> ansList = new ArrayList<Integer>();
        while(!genreQueue.isEmpty()) {
        	Genre currGenre = genreQueue.poll();
        	if(currGenre.musicQueue.size()==1) {
        		ansList.add(currGenre.musicQueue.poll().index);
        	}else {
        		ansList.add(currGenre.musicQueue.poll().index);
        		ansList.add(currGenre.musicQueue.poll().index);
        	}
        }
        return ansList.stream().mapToInt(x->x).toArray();
    }
	
	public static void main(String[] args) {
		Solution_베스트앨범 solution = new Solution_베스트앨범();
		System.out.println(solution.solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500}));
	}

}
