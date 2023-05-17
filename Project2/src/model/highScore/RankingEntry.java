package model.highScore;

import java.io.Serializable;

public class RankingEntry implements Serializable {

    int position;
    String nickname;
    int score;
    String time;

    public RankingEntry(int position, String nickname, int score, String time) {
        this.position = position;
        this.nickname = nickname;
        this.score = score;
        this.time = time;
    }

    public int getScore() {
        return score;
    }


    @Override
    public String toString() {
        return position + " ----------- " + score + " ----------- " + nickname + " ----------- " + time;
    }
}
