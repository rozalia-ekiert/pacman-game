package model.game;

import model.map.MapModel;

public class MapRedraw extends Thread {

    private static final Object mapMonitor = MapModel.mapMonitor;
    int[][] map;

    public MapRedraw(int[][] map) {
        this.map = map;
    }

//    public void run() {
//        synchronized (mapMonitor) {
//            while (MapModel.cookiesCounter!=0) {
//                try {
//                    mapMonitor.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            while ()
//        }
//    }
}
