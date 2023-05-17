package model.highScore;

import java.io.Serializable;

public class RankingEntry implements Serializable {

    int position;
    String nickname;
    int score;
    String time;

    public RankingEntry(String nickname, int score, String time) {
//        this.position = setPosition(score);
        this.nickname = nickname;
        this.score = score;
        this.time = time;
    }

    public int getScore() {
        return score;
    }

//    public int setPosition(int score) {
//        int tmp;
//        int finalPosition = 0;
//
//        return finalPosition;
//    }

//    @Override
//    public String toString() {
//        return nickname + ' ' + NumberFormatter.changeScoreToString(score) + ' ' + time;
//    }

    //String yourFinalScore = NumberFormatter.changeScoreToString(CurrentStats.yourScore);
}
