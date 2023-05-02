import model.Map.MapGenerator;

public class Main {


    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "True");

//        PACMANGame graPanel = new PACMANGame();
        MapGenerator mapGenerator = new MapGenerator(10, 21);

    }
}