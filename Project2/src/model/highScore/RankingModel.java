package model.highScore;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RankingModel extends AbstractListModel implements Serializable {

    public static final String rankingFile = "Project2/ranking.txt";
    public static List<RankingEntry> entries;
    private final String[] columnNames = {"POSITION", "NICKNAME", "SCORE", "TIME"};

    public RankingModel() {
        entries = new ArrayList<>();
    }

    public void addEntry(RankingEntry entry) {
        entries.add(entry);
        fireIntervalAdded(this, entries.size() - 1, entries.size() - 1);
    }

    public void addEntryWithSorting(RankingEntry entry) {
        entries.add(entry);

        Collections.sort(entries, Comparator.comparingInt(RankingEntry::getScore).reversed());
        fireContentsChanged(this, 0, entries.size() - 1);
    }

    @Override
    public int getSize() {
        return entries.size();
    }

    @Override
    public RankingEntry getElementAt(int index) {
        return entries.get(index);
    }

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rankingFile))) {
            oos.writeObject(entries);
            System.out.println("Ranking zapisany do pliku: " + rankingFile);
        } catch (IOException e) {
            System.out.println("Błąd podczas zapisywania rankingu do pliku: " + rankingFile);
            e.printStackTrace();
        }
    }

    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rankingFile))) {
            entries = (List<RankingEntry>) ois.readObject();
            System.out.println("Ranking wczytany z pliku: " + rankingFile);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Błąd podczas wczytywania rankingu z pliku: " + rankingFile);
            e.printStackTrace();
        }
    }


}
