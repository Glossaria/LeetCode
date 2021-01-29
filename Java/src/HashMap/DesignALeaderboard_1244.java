package HashMap;


import java.util.*;
import java.util.stream.Collectors;

class Leaderboard {
    private static Map<Integer, Integer> scoreBoard ;
    
    public Leaderboard() {
        scoreBoard = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) { 
        scoreBoard.put(playerId ,
                       scoreBoard.getOrDefault(playerId, 0) + score);
    }
    
    public int top(int K) {
        List<Integer> l = new ArrayList<Integer>(scoreBoard.values());
        Collections.sort(l, Collections.reverseOrder());
        l = l.subList(0,K);
        return l.stream().collect(
            Collectors.summingInt(Integer::intValue));
    }
    
    public void reset(int playerId) {
        scoreBoard.put(playerId,0);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */