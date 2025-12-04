package ua.opnu;

/**
 * Базовый класс для игровых фигур (камень, ножницы, бумага).
 */
public abstract class GameShape {

    /**
     * Человеко-читаемое имя фигуры.
     */
    public abstract String getName();

    /**
     * Сравнение двух фигур.
     *
     * @param other другая фигура
     * @return 1  — если this выигрывает у other
     *        -1  — если this проигрывает other
     *         0  — если ничья
     */
    public abstract int compare(GameShape other);

    @Override
    public String toString() {
        return getName();
    }
}
