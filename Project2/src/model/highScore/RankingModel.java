package model.highScore;

import model.NumberFormatter;

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
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File(rankingFile));

            for (int i = 0; i < entries.size(); i++) {
                fw.write((i + 1) + ". " + entries.get(i).score + " " + entries.get(i).nickname +
                        " " + entries.get(i).time + "\n");
            }

        } catch (IOException e) {
            System.out.println("Błąd podczas zapisywania rankingu do pliku: " + rankingFile);
            e.printStackTrace();
        }
    }

    public void loadFromFile() {
        FileReader fr = null;
        try {
            fr = new FileReader(rankingFile);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            while (line != null) {
                String[] tab = line.split(" ");
                int score = Integer.parseInt(tab[1]);
                String nickname = tab[2];
                String time = tab[3];
                addEntryWithSorting(new RankingEntry(nickname, score, time));
            }

            for (RankingEntry entry : entries) {
                System.out.println(entry.nickname + ' ' +
                        NumberFormatter.changeScoreToString(entry.score) + ' ' + entry.time);
            }

        } catch (IOException e) {
            System.out.println("Błąd podczas wczytywania rankingu z pliku: " + rankingFile);
            e.printStackTrace();
        }
    }

//    public void saveToFile() {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rankingFile))) {
//            oos.writeObject(entries);
//            System.out.println("Ranking zapisany do pliku: " + rankingFile);
//        } catch (IOException e) {
//            System.out.println("Błąd podczas zapisywania rankingu do pliku: " + rankingFile);
//            e.printStackTrace();
//        }
//    }

//    public void loadFromFile() {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rankingFile))) {
//            entries = (List<RankingEntry>) ois.readObject();
//            System.out.println("Ranking wczytany z pliku: " + rankingFile);
//
//            for (RankingEntry entry : entries){
//                System.out.println(entry.nickname + ' ' +
//                        NumberFormatter.changeScoreToString(entry.score) + ' ' + entry.time);
//            }
//
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("Błąd podczas wczytywania rankingu z pliku: " + rankingFile);
//            e.printStackTrace();
//        }
//    }


}
