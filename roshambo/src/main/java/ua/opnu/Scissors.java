package ua.opnu;

public class Scissors extends GameShape {

    @Override
    public String getName() {
        return "Scissors";
    }

    @Override
    public int compare(GameShape other) {
        if (other instanceof Scissors) {
            return 0;
        }
        if (other instanceof Paper) {
            return 1;   // ножницы режут бумагу
        }
        if (other instanceof Rock) {
            return -1;  // камень ломает ножницы
        }
        return 0;
    }
}
