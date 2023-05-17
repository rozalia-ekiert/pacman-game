package model.highScore;

import javax.swing.*;
import java.util.ArrayList;

public class RankingModel extends AbstractListModel {

    private ArrayList<HighScoreData> entries;
    private String[] columnNames = {"NUMBER", "NICKNAME", "SCORE", "TIME"};

    public RankingModel() {
        entries = new ArrayList<>();
    }

    public void addEntry(HighScoreData entry) {
        entries.add(entry);
        fireIntervalAdded(this, entries.size() - 1, entries.size() - 1);
    }


    @Override
    public int getSize() {
        return entries.size();
    }

    @Override
    public HighScoreData getElementAt(int index) {
        return entries.get(index);
    }
}
