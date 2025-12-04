package ua.opnu;

public class Paper extends GameShape {

    @Override
    public String getName() {
        return "Paper";
    }

    @Override
    public int compare(GameShape other) {
        if (other instanceof Paper) {
            return 0;
        }
        if (other instanceof Rock) {
            return 1;   // бумага заворачивает камень
        }
        if (other instanceof Scissors) {
            return -1;  // ножницы режут бумагу
        }
        return 0;
    }
}
