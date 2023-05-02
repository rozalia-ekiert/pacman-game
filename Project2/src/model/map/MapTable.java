package model.map;

import javax.swing.*;

public class MapTable extends JTable {

    public MapTable(int rows, int columns, MapModel model) {
        JTable map = new JTable(model);
        this.add(map);

    }

}
