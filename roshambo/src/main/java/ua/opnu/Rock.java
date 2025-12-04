package ua.opnu;

public class Rock extends GameShape {

    @Override
    public String getName() {
        return "Rock";
    }

    @Override
    public int compare(GameShape other) {
        if (other instanceof Rock) {
            return 0;
        }
        if (other instanceof Scissors) {
            return 1;   // камень ломает ножницы
        }
        if (other instanceof Paper) {
            return -1;  // бумага заворачивает камень
        }
        return 0;
    }
}
